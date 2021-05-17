package com.jrp.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class project {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_generator")
	@SequenceGenerator(name = "project_generator", sequenceName = "project_seq", allocationSize = 1)
	private long projectId;
	private String name;
	private String stage; //incomplete, completed , in progress
	private String description;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, 
			CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name="project_Employee", joinColumns= @JoinColumn(name="project_Id"),
	inverseJoinColumns= @JoinColumn(name="employee_Id"))
	
	@JsonIgnore
	private List<Employee> employees;
	
	
	public project() {
		
	}
	
	
	public void addEmployee(Employee emp) {
		if (employees == null) {
			employees = new ArrayList<>();
			}
			
		employees.add(emp);
		
	}
	
	
	
	
	public project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}


	public long getProjectId() {
		return projectId;
	}


	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
