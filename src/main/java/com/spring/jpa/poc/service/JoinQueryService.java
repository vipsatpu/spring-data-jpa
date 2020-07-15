package com.spring.jpa.poc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.poc.dto.EmpDeptDTO;
import com.spring.jpa.poc.entity.Employee;
import com.spring.jpa.poc.repository.DepartmentRepo;
import com.spring.jpa.poc.repository.EmployeeRepo;
import com.spring.jpa.poc.specs.EmployeeSepcs;

@Service
public class JoinQueryService {

	@Resource
	private DepartmentRepo departmentRepo;

	@Resource
	private EmployeeRepo employeeRepo;
	
	@Autowired
	EmployeeSepcs employeeSpecs;

	public List<EmpDeptDTO> getDeptEmployeesLeftJoin() {
		List<EmpDeptDTO> list = departmentRepo.fetchEmpDeptDataLeftJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	public List<EmpDeptDTO> getDeptEmployeesRightJoin() {
		List<EmpDeptDTO> list = departmentRepo.fetchEmpDeptDataRightJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	public List<EmpDeptDTO> getDeptEmployeesInnerJoin() {
		List<EmpDeptDTO> list = employeeRepo.fetchEmpDeptDataInnerJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}

	public List<EmpDeptDTO> getDeptEmployeesCrossJoin() {
		List<EmpDeptDTO> list = employeeRepo.fetchEmpDeptDataCrossJoin();
		list.forEach(l -> System.out.println(l));
		return list;
	}
	public List<Employee> getEmployeeBySpecs() {
		List<Employee> employees = employeeRepo.findAll(employeeSpecs.getFromEmailAddress("avisek@gmail.com"));
		employees.forEach(e -> System.out.println(e.getEmail()));
		return employees;
	}

}
