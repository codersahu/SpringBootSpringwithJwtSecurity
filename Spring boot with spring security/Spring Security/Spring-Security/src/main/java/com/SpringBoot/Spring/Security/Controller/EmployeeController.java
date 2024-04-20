package com.SpringBoot.Spring.Security.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Spring.Security.Entity.Employee;
import com.SpringBoot.Spring.Security.Service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/welcome")
	@PreAuthorize("hasAuthority('ROLE_USER')")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }
	
	@PostMapping("/saveadduser")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee emp) {
		Employee saveEmployee = empService.saveEmployee(emp);
		return new ResponseEntity(saveEmployee,HttpStatus.OK) ;
		
	}

	@GetMapping("/getall")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> getAll() {
		List<Employee> all = empService.getAll();
		return new ResponseEntity(all,HttpStatus.OK);
	}
	
	
}
