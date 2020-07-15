package com.spring.jpa.poc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.poc.dto.ProductDTO;
import com.spring.jpa.poc.entity.Product;
import com.spring.jpa.poc.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(service.getProducts(), HttpStatus.OK);
	}

	@PostMapping("/products")
	public ResponseEntity<List<Product>> getProductsByIds(@RequestBody ProductDTO input) {
		return new ResponseEntity<List<Product>>(service.getProductsByIds(input.getIds()), HttpStatus.OK);
	}

	@PostMapping("/delete/products")
	public ResponseEntity<Void> deleteProducts(@RequestBody ProductDTO input) {
		service.deleteProducts(input.getIds());

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
