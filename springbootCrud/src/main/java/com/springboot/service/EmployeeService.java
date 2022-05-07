package com.springboot.service;

import java.util.List;

import com.springboot.Employee;




public interface EmployeeService {

	 Employee saveEmployee(Employee employee);
	 
	 List<Employee> getEmployee();
	 
	 Employee getEmployeeById(long id); 
	 
	 Employee updateEmployee(Employee emp, long id);
	 
	 void deleteEmployee(long id);
	 
	 void testMethod();
}


