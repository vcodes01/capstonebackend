package com.victoria.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victoria.backend.models.Product;
import com.victoria.backend.repositories.ProductRepository;

// RestController is a Spring Annotation that is used to build REST API. This will tell Spring to do its configurations and allows us to make RESTful web service runtime

@RestController
@RequestMapping("/api/v1/") //thats what all of the end points start with 
public class ProductController {
	@Autowired 
	//Beans are objects 
	//Autowiring happens by placing an instance of one bean into an instance of another bean
	private ProductRepository productRepo;
	
	@GetMapping("/allproducts") 
	public List <Product> getAllProducts() {
		return productRepo.findAll();
	}
	

}
