package com.spring.jpa.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.jpa.poc.dto.EmpDeptDTO;
import com.spring.jpa.poc.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

	@Query("SELECT new com.spring.jpa.poc.dto.EmpDeptDTO(d.name, e.name, e.email, e.address) "
			+ "FROM Department d LEFT JOIN d.employees e")
	List<EmpDeptDTO> fetchEmpDeptDataLeftJoin();

	@Query("SELECT new com.spring.jpa.poc.dto.EmpDeptDTO (d.name, e.name, e.email, e.address) "
			+ "FROM Department d RIGHT JOIN d.employees e")
	List<EmpDeptDTO> fetchEmpDeptDataRightJoin();

}
