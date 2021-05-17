 package com.jrp.pma.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrp.pma.dao.EmpRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.services.EmployeeService;

@Controller	
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService EmpSer;
	
	@GetMapping("/new") 
	public String employeeForm(Model model) {
		
		Employee emp = new Employee();
		
		model.addAttribute("employee",emp);
		return "employees/new-employee";
		
	}
	
	
	@PostMapping("/save")
	public String saveForm(Model model, Employee emp1) {
		EmpSer.save(emp1);
		
		return "redirect:/employee";
	}
	
	
	@GetMapping
	public String EmpDatabase(Model model) {
		
		List<Employee> empData = EmpSer.getAll();
		
		model.addAttribute("emp", empData);
		
		return "employees/employeeData"; 
	}
		
	
	@GetMapping("/update")
	public String UpdateEntity(@RequestParam("id") long id, Model model) {
	
	
	 	Employee updatedEmp = EmpSer.findByEmployeeId(id); 
	 	model.addAttribute("employee", updatedEmp);
	  	
     	return "employees/new-employee";
	}
	
	
	@GetMapping("/delete")
	public String deleteEntity(@RequestParam("id") long id) {
	
		
	 	EmpSer.delete(id);
	  	
     	return "redirect:/employee";
	}
	
	
	
	
}
