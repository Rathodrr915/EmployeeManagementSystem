package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.entity.Employee;
import com.amdocs.service.EmployeeService;

@RestController
public class MyController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees() {
		return employeeService.fetchAllEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployeeById(id, employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		return employeeService.deleteEmployeeById(id);
	}


}
