package com.victoria.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victoria.backend.models.Product;

@Repository 
//@Repository is a spring annotation that indicated that the 

public interface ProductRepository extends JpaRepository<Product, Integer> {

} 
