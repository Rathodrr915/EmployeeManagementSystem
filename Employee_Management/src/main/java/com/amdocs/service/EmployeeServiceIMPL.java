package com.amdocs.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.entity.Employee;
import com.amdocs.repo.EmployeeRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		List<Employee> allEmployees = employeeRepository.findAll();
		return allEmployees;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(id);
		
		if(emp.isPresent()) {
			Employee existingEmployee = emp.get();
			
			if(Objects.nonNull(employee.getEmpFirstName()) && !"".equalsIgnoreCase(employee.getEmpFirstName())) {
				existingEmployee.setEmpFirstName(employee.getEmpFirstName());
			}
			if(Objects.nonNull(employee.getEmpLastName()) && !"".equalsIgnoreCase(employee.getEmpLastName())) {
				existingEmployee.setEmpLastName(employee.getEmpLastName());
			}
			if(Objects.nonNull(employee.getEmpEmail()) && !"".equalsIgnoreCase(employee.getEmpEmail())) {
				existingEmployee.setEmpEmail(employee.getEmpEmail());
			}
			
			
			
			
			return employeeRepository.save(existingEmployee);
		}
		
		return null;
	}

	@Override
	public String deleteEmployeeById(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee Deleted Successfully!";
		}
		return "No such employee in the database";
	}
}
