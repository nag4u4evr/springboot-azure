package com.sample.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.example.dao.Employee;

@Service
public class EmployeeService {
	
	
	List<Employee> ob=new ArrayList<>();
	public List<Employee> doSaveEmployee(Employee employee) {
		
		Employee n=new Employee();
		n.setCode(employee.getCode());
		n.setFirstName(employee.getFirstName());
		n.setLastName(employee.getLastName());
		n.setAddress(employee.getAddress());
		ob.add(n);
		System.out.println("Done adding employee");
		return ob;
	}
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return ob;
	}

}
