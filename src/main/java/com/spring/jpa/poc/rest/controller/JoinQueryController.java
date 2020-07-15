package com.spring.jpa.poc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.poc.dto.EmpDeptDTO;
import com.spring.jpa.poc.entity.Employee;
import com.spring.jpa.poc.service.JoinQueryService;

@RestController
public class JoinQueryController {

	@Autowired
	private JoinQueryService joinQueryService;

	@GetMapping("/dept/employees/left")
	public ResponseEntity<List<EmpDeptDTO>> getDeptEmployeesLeftJoin() {
		return new ResponseEntity<List<EmpDeptDTO>>(joinQueryService.getDeptEmployeesLeftJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/right")
	public ResponseEntity<List<EmpDeptDTO>> getDeptEmployeesRightJoin() {
		return new ResponseEntity<List<EmpDeptDTO>>(joinQueryService.getDeptEmployeesRightJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/inner")
	public ResponseEntity<List<EmpDeptDTO>> getDeptEmployeesInnerJoin() {
		return new ResponseEntity<List<EmpDeptDTO>>(joinQueryService.getDeptEmployeesInnerJoin(), HttpStatus.OK);
	}

	@GetMapping("/dept/employees/cross")
	public ResponseEntity<List<EmpDeptDTO>> getDeptEmployeesCrossJoin() {
		return new ResponseEntity<List<EmpDeptDTO>>(joinQueryService.getDeptEmployeesCrossJoin(), HttpStatus.OK);
	}
	
	@GetMapping("/dept/employees/specs")
	public ResponseEntity<List<Employee>> getEmployeesBySpecs() {
		return new ResponseEntity<List<Employee>>(joinQueryService.getEmployeeBySpecs(), HttpStatus.OK);
	}
}
