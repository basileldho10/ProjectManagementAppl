package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jrp.pma.dto.ProjectEmployees;
import com.jrp.pma.entities.Employee;

public interface EmpRepository extends PagingAndSortingRepository<Employee, Long> {

	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT p.project_id as ProjectId, p.name as ProjectName, count(pe.employee_id) as ProjectMembers "
			+ "FROM PROJECT P right join PROJECT_EMPLOYEE PE "
			+ "on p.project_id=pe.project_id "
			+ "group by p.project_id")
	public List<ProjectEmployees> ProjectCount();
	
	@Override
	public void delete(Employee emp);


	public Employee findByEmployeeId(long id);
	
	
	public Employee findByEmail(String value);
	

}
 