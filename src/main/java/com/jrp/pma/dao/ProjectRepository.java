package com.jrp.pma.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jrp.pma.dto.ProjectProgress;
import com.jrp.pma.entities.project;

public interface ProjectRepository extends CrudRepository<project, Long> {

 @Override	
	public List<project> findAll();

	
	@Query(nativeQuery=true, value="SELECT p.stage as label, count(p.stage) as value "
			+ "FROM PROJECT p "
			+ "group by p.stage")
	public List<ProjectProgress> ProjectStage();
	
}
