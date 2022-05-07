package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Employee;
import com.springboot.service.EmployeeService;

@RestController
//@RequestMapping("/api/Employees") 
public class EmployeeController {

	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	} 
	
	@PostMapping()
	public ResponseEntity<Employee> empDetails (@RequestBody Employee employee) {
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED) ;
	}
	
	@GetMapping("/emp")
	public List<Employee> getEmployeeList () {
		
		return employeeService.getEmployee();
	}
	
	@RequestMapping("emp/{id}")
	public Employee getEmployeeById (@PathVariable("id") long id) {
		
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("updateEmp/{id}")
	public Employee updateEmployeeById (@PathVariable("id") long id, @ RequestBody() Employee employee) {
		
		return employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping("deleteEmp/{id}")
	public void deleteEmployeeById (@PathVariable("id") long id) {
		
		 employeeService.deleteEmployee(id);
	}
}
