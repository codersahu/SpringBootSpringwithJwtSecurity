package com.SpringBoot.Spring.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.Spring.Security.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	Optional<Employee> findByName(String username);

}
