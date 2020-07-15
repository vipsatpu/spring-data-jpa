package com.spring.jpa.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jpa.poc.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query("SELECT p FROM Product p WHERE p.id IN (:ids)")
	public List<Product> findProductsByIds(@Param("ids") List<Integer> ids);

	@Modifying
	@Query("DELETE FROM Product p WHERE p.id IN (:ids)")
	public void deleteProductsByIds(@Param("ids") List<Integer> ids);
}
