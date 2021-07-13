package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;


@Service
public class EmployeeService implements EmployeeServiceImpl {

@Autowired
EmployeeRepository e;
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return e.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return e.findById(theId).get();
	}

	@Override
	public void save(Employee theEmployee) {
		e.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
	Employee e1=e.findById(theId).get();
	e.delete(e1);

	}

	@Override
	public List<Employee> findAllByOrderByLastNameAsc() {
		// TODO Auto-generated method stub
		return e.findAllByOrderByLastNameAsc();
	}

}
