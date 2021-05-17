package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ProjectProgress;
import com.jrp.pma.entities.project;

@Service
public class ProjectServices {

	
	@Autowired
	ProjectRepository proRep;
	
	
	public List<project> getAll(){
		return proRep.findAll();
	}
	
	
	public List<ProjectProgress> getStage(){
		return proRep.ProjectStage();	
	}
	
	
	public project save(project project1) {
		return proRep.save(project1);
	}
	
	
}
