package com.luv2code.springboot.thymeleafdemo.service;
import java.util.*;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
public interface EmployeeServiceImpl {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
