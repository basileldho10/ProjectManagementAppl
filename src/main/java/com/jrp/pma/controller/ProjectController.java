package com.jrp.pma.controller;


import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.project;
import com.jrp.pma.services.EmployeeService;
import com.jrp.pma.services.ProjectServices;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectServices proRepo;
	
	@Autowired
	EmployeeService empRep;

	@RequestMapping("/new")
	public String displayForm(Model model) {
		
		project aproject = new project();
        List<Employee> projectEmp = empRep.getAll();
        
		model.addAttribute("project", aproject);
		model.addAttribute("allEmployees",projectEmp);
		return "projects/new-projects";
		
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createProject(project project1,Model model) {
	   proRepo.save(project1);
	   
	
	   
	   return "redirect:/projects";
	}
	
	
	@GetMapping
	public String projectData(Model model) {
		
		List<project> projectList = proRepo.getAll();
		model.addAttribute("projects", projectList);
		
		return "projects/projectsData";
	}

	
}
