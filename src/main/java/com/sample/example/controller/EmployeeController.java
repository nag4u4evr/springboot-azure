package com.sample.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.example.dao.Employee;
import com.sample.example.service.EmployeeService;

@RestController 
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "Application is running";
	}
	
	@GetMapping("/allemployees")
	public List<Employee> getALLEmployees() {
		return employeeService.getEmployees();
	}
	
	@PostMapping("/api/v1/employees")
	public List<Employee> saveEmployee(@RequestBody Employee employee) {
	
		return employeeService.doSaveEmployee(employee);
	}
	
	

}
