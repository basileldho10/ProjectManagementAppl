package com.jrp.pma.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.pma.dao.EmpRepository;
import com.jrp.pma.entities.Employee;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

	@Autowired
	EmpRepository empRepo;
	
	
	@GetMapping
	public Iterable<Employee> getEmplpoyees(){
		return empRepo.findAll(); 
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getEmpbyId(@PathVariable("id") long id){
		return empRepo.findById(id);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee CreateEmployee(@RequestBody @Validated Employee emp) {
		return empRepo.save(emp);
	}
	
	@PatchMapping(path="/{id}", consumes= "application/json")
	public Employee partialUpdate(@PathVariable("id") long id,@RequestBody @Validated Employee patchEmp) {
		
		Employee emp = empRepo.findById(id).get();
		
		if (patchEmp.getEmail()!=null) {
			emp.setEmail(patchEmp.getEmail());
		}
		
		if (patchEmp.getFirstName()!=null) {
			emp.setFirstName(patchEmp.getFirstName());
		}
		
		if (patchEmp.getLastName()!=null) {
			emp.setLastName(patchEmp.getLastName());
		}
		
		return empRepo.save(emp);		
		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable("id") long id) {
		
	try {
		empRepo.deleteById(id);
		}
	catch(EmptyResultDataAccessException e) {
		
	}
		}
	
	
//	@GetMapping
//	@ResponseStatus(HttpStatus.OK)
//	public Iterable<Employee> findSortedEmployees(@RequestParam("id") int id){
//	
//	Sort sorter = new Sort();
//		
//		
//	}
	
	
	
}

