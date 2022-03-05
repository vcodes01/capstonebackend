package com.victoria.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victoria.backend.models.Camera;

@Repository 
//@Repository is a spring annotation that indicated that the 

public interface CameraRepository extends JpaRepository<Camera, Integer> {

} 
