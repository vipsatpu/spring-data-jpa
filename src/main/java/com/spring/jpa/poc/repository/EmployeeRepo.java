package com.spring.jpa.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.poc.dto.EmpDeptDTO;
import com.spring.jpa.poc.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

	@Query("SELECT new com.spring.jpa.poc.dto.EmpDeptDTO(d.name, e.name, e.email, e.address) "
			+ "FROM Department d INNER JOIN d.employees e")
	List<EmpDeptDTO> fetchEmpDeptDataInnerJoin();

	@Query("SELECT new com.spring.jpa.poc.dto.EmpDeptDTO(d.name, e.name, e.email, e.address) "
			+ "FROM Department d, Employee e")
	List<EmpDeptDTO> fetchEmpDeptDataCrossJoin();

}
