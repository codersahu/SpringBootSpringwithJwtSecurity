package com.SpringBoot.Spring.Security.Config.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.SpringBoot.Spring.Security.Entity.Employee;
import com.SpringBoot.Spring.Security.Repository.EmployeeRepo;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  Optional<Employee> byUserName = empRepo.findByName(username);
		return byUserName.map(UserDetailsImpl::new)
				.orElseThrow(()->new UsernameNotFoundException("User not found"+username));
	}

}
