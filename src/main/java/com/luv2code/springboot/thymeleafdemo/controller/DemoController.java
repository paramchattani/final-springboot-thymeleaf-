package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class DemoController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String sayHello(Model theModel)
	{
	
	List<Employee> l =employeeService.findAllByOrderByLastNameAsc();	
	theModel.addAttribute("employees", l);
	
	return "employees/list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String addEmployee(Model theModel)
	{
		Employee e=new Employee();
		theModel.addAttribute("employee", e);
		return "employees/employee-form";
	}


	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee theEmployee)
	{
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId")int theid , Model theModel) {
		
		Employee ea=employeeService.findById(theid);
		theModel.addAttribute("employee", ea);
		
		return "employees/employee-form" ;
}
	
@GetMapping("/showFormForDelete")
public String deleteEmployee(@RequestParam("employeeId")int theId)
{
	//Employee ex=employeeService.findById(theId);
	employeeService.deleteById(theId);
	return "redirect:/employees/list";
	
}

}
