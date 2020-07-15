package com.spring.jpa.poc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.poc.entity.Product;
import com.spring.jpa.poc.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	public List<Product> getProductsByIds(List<Integer> ids) {
		return productRepo.findProductsByIds(ids);
	}

	@Transactional
	public void deleteProducts(List<Integer> ids) {
		productRepo.deleteProductsByIds(ids);
	}

}
