package com.victoria.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victoria.backend.exceptions.ResourceNotFoundException;
import com.victoria.backend.models.Camera;
import com.victoria.backend.repositories.CameraRepository;

// RestController is a Spring Annotation that is used to build REST API. This will tell Spring to do its configurations and allows us to make RESTful web service runtime

@RestController
@RequestMapping("/api/v1/") //thats what all of the end points start with 
public class CameraController {
	@Autowired 
	//Beans are objects 
	//Autowiring happens by placing an instance of one bean into an instance of another bean
	private CameraRepository cameraRepo;
	
	@GetMapping("/allcameras") 
	public List <Camera> getAllCameras() {
		return cameraRepo.findAll();
	}
	//ResponseEntity represents the whole HTTP response: status code, headers, and body.
	//@PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable.

	@GetMapping("camera/{id}")
	public ResponseEntity<Camera> getCameraById(@PathVariable int id) {
		Camera camera = cameraRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Camera not found."));
				return ResponseEntity.ok(camera);
	};
	@PostMapping("addcamera")
	public Camera newCamera(@RequestBody Camera camera) {
		return cameraRepo.save(camera);

	}
//	@PutMapping("student/{id}")
//	public ResponseEntity<Camera> updateCamera(@PathVariable int id, @RequestBody Camera newCameraInfo) {
//		Camera foundCamera = cameraRepo.findById(id)
//			.orElseThrow(() -> new ResourceNotFoundException("Camera not found."));
//		
//		foundCamera.setPrice(camera.getCamera());
//	}
//	
	//Use PathVariable to grab the value of {id} parameter from URI
	@DeleteMapping("camera/{id}")
	public ResponseEntity<String> deleteCamera(@PathVariable int id) {
		//find user we want to delete
		cameraRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Camera not found."));
		
		String message = "Camera has been deleted.";
				
		//delete method from jpa. deletes entity from database
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
