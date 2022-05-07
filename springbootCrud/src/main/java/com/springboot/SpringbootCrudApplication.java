package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.service.EmployeeService;

@SpringBootApplication
public class SpringbootCrudApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Testing command line runner");
		employeeService.testMethod();
	}
}
