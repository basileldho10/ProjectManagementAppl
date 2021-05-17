package com.jrp.pma.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.EmpRepository;
import com.jrp.pma.dto.ProjectEmployees;
import com.jrp.pma.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmpRepository empRep;
	
	
	public List<Employee> getAll(){
		return empRep.findAll();
	}
	
	
	public List<ProjectEmployees> getCount(){
		return empRep.ProjectCount();
	}
	
	
	public Employee save(Employee employee) {
		return empRep.save(employee);
	}
	
	
	public void delete(long emp) {
	   empRep.deleteById(emp);
	}


	public Employee findByEmployeeId(long id) {
		return empRep.findByEmployeeId(id);
	}
}
