package com.SpringBoot.Spring.Security.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = 	GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String department;
	private String password;
	private String roles;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", password=" + password
				+ ", roles=" + roles + "]";
	}
	public Employee(Integer id, String name, String department, String password, String roles) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.password = password;
		this.roles = roles;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
