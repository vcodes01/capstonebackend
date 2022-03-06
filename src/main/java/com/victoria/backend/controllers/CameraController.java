package com.victoria.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victoria.backend.exceptions.ResourceNotFoundException;
import com.victoria.backend.models.Camera;
import com.victoria.backend.repositories.CameraRepository;



//RestController is a Spring Annotation that is used to build REST API. This will tell Spring to do its configurations and allows us to make RESTful web service runtime
@RestController
@CrossOrigin
@RequestMapping("/api/v1/") //thats what all of the end points start with
public class CameraController {
	
//	                                AUTOWIRED
//	Reminder: all Spring beans are handled in our Spring container AKA Application Context.
//	Our Spring container handles all of our objects (Beans), that includes definitions, WIRING them automatically, sending them out whenever we need them, creation, and deletion.
//all of our beans are AUTOWIRED in the Spring Container
//Autowiring happens by placing an instance of one bean into an instance of another bean.
//Annotaion Autowired is a feature in Spring framework that enables dependency injection implicitly.
//Tells our application context to inject an instance of CameraRepository in this class.
	
	@Autowired
	private CameraRepository cameraRepo;
	
	@GetMapping("allcameras")
	public List<Camera> getAllCameras() { 
		return cameraRepo.findAll();
	}
	
	
//ResponseEntity represents the whole HTTP response: status code, headers, and body.
//@PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable
	@GetMapping("camera/{id}")
	public ResponseEntity<Camera> getCameraById(@PathVariable int id) {
		Camera camera = cameraRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Camera not found."));
				return ResponseEntity.ok(camera);
	}
	
	@GetMapping("allcameras/{camname}")
	public List<Camera> getCamerasByCamname(@PathVariable String camname) {
		List<Camera> cameras = cameraRepo.findByCamname(camname);
		if(cameras.isEmpty()) {
			System.out.println(new ResourceNotFoundException("Camera(s) with the name " + camname + " not found."));
		}
		return cameraRepo.findByCamname(camname);
	}
	
//	Saves a given entity. Create camera
	@PostMapping("addcamera")
	public Camera newCamera(@RequestBody Camera camera) {
		return cameraRepo.save(camera);
	}	
	
	@PutMapping("camera/{id}")
	public ResponseEntity<Camera> updateCamera(@PathVariable int id, @RequestBody Camera newCameraInfo) {
		Camera foundCamera = cameraRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Camera not found."));
		
//		Update info of found camera using setters with the new info from req.body using getters.
		foundCamera.setCamname(newCameraInfo.getCamname());
		foundCamera.setPrice(newCameraInfo.getPrice());
		
		Camera updatedCamera = cameraRepo.save(foundCamera);
		
		return ResponseEntity.ok(updatedCamera);
	}
	
//	Use PathVariable to grab the value of {id} parameter from URI
	@DeleteMapping("camera/{id}")
	public ResponseEntity<String> deleteCamera(@PathVariable int id) {
//		Find user we want to delete
		cameraRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Camera not found."));
		
		String message =  "Camera has been deleted.";
		
//		Delete method from Jpa. Deletes entity from database.
		cameraRepo.deleteById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}

