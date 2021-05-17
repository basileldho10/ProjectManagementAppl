package com.jrp.pma.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.jrp.pma.dao.EmpRepository;
import com.jrp.pma.entities.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

	
	@Autowired
	EmpRepository empRepo;
	
	
	@Override
	// Checks if assigned email already exists within database
	public boolean isValid(String value, ConstraintValidatorContext context) {
	Employee emp = empRepo.findByEmail(value);
	
	if (emp!=null) 
		return false;
	else
		return true;
	
	}
}
