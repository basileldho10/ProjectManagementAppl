package com.jrp.pma.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.pma.dao.EmpRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ProjectEmployees;
import com.jrp.pma.dto.ProjectProgress;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmpRepository empRepo;

	@GetMapping("/")
	public String homePage(Model model) throws JsonProcessingException {
		
		Map<String, Object> blabla = new HashMap<>();
		
		
		List<ProjectEmployees> EmpCount = empRepo.ProjectCount();
        List<ProjectProgress> projectReport = proRepo.ProjectStage();
		
        
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectReport);
        
        
	    model.addAttribute("CountFeature",EmpCount);
	    model.addAttribute("projectStageVisual",jsonString);
	    return "main/Home";	   
	   
	    
	}
	
	
}
