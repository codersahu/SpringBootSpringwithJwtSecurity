package com.SpringBoot.Spring.Security.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringBoot.Spring.Security.Entity.Employee;
import com.SpringBoot.Spring.Security.Repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo empRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee emp = new Employee();
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		emp.setDepartment(employee.getDepartment());
		emp.setRoles(employee.getRoles());
		
		emp.setPassword(passwordEncoder.encode(employee.getPassword()));
		
		Employee saveEmp = empRepo.save(emp);
		return saveEmp;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> allEmployee = empRepo.findAll();
		return allEmployee;
	}

	
}


