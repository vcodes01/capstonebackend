package com.victoria.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victoria.backend.models.Camera;

 // JPAreposiroty - JPA stands for Java Persistance API - It contains API for basic CRUD operations and it can also do pagination and sorting      
//@Repository is a spring annotation that indicated t
@Repository
public interface CameraRepository extends JpaRepository<Camera, Integer> {

	//created our own abstract method 

List<Camera> findByCamname(String camname);

} 
