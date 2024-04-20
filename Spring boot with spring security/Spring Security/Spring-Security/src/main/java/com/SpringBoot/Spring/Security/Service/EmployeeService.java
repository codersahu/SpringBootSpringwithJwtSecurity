package com.SpringBoot.Spring.Security.Service;

import java.util.List;

import com.SpringBoot.Spring.Security.Entity.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);
	public List<Employee> getAll();

}
