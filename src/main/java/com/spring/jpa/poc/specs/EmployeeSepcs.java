package com.spring.jpa.poc.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.spring.jpa.poc.entity.Employee;

@Component
public class EmployeeSepcs {

	public static Specification<Employee> getFromEmailAddress(String email){
		return new Specification<Employee> () {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query,
		            CriteriaBuilder builder) {
				return builder.equal(root.get("email"), email);
			}

		};
	}
}
