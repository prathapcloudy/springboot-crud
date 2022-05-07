package com.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.Employee;
import com.springboot.exception.copy.ResourceNotFoundException;
import com.springboot.repository.EmployeeRepository;
import com.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	// if we have only one constructor no need to mention Autowired. it will automatically create bean
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	
	}


	@Override
	public List<Employee> getEmployee() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		
//		Optional<Employee> emp = employeeRepository.findById(id);
//
//		if (emp.isPresent()) {
//			return emp.get();
//		} else {
//			throw new ResourceNotFoundException("Resource not found", "Id", id);
//		}
//		
		//using lambada expression
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}


	@Override
	public Employee updateEmployee(Employee emp, long id) {
		    Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		
		    employee.setFirstName(emp.getFirstName());
		    employee.setLastName(emp.getLastName());
		    employee.setEmail(emp.getEmail());
		    
		    employeeRepository.save(employee);
		    
		    return employee;
	}


	@Override
	public void deleteEmployee(long id) {
		 employeeRepository.deleteById(id);
		
	}


	@Override
	public void testMethod() {
		System.out.println("TESTING THIS Method");
		
	}
	

}
