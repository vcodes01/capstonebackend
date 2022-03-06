package com.victoria.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victoria.backend.models.Camera;

 
//@Repository is a spring annotation that indicated that the 
@Repository
public interface CameraRepository extends JpaRepository<Camera, Integer> {

	//created our own abstract method 

List<Camera> findByCamname(String camname);

} 
