package com.amdocs.service;

import java.util.List;

import com.amdocs.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	
	List<Employee> fetchAllEmployees();
	
	Employee getEmployeeById(Long id);
	
	Employee updateEmployeeById(Long id, Employee employee);
	
	String deleteEmployeeById(Long id);

}
