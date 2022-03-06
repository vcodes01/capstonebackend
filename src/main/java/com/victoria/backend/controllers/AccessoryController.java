package com.victoria.backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.victoria.backend.exceptions.ResourceNotFoundException;
import com.victoria.backend.models.Accessory;
import com.victoria.backend.repositories.AccessoryRepository;

@RestController 
public class AccessoryController {
	
private AccessoryRepository accessoryRepo;
	
	@GetMapping("allaccessories")
	public List<Accessory> getAllaccessories() { 
		return accessoryRepo.findAll();
	}
	
	
//ResponseEntity represents the whole HTTP response: status code, headers, and body.
//@PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable
	@GetMapping("accessory/{id}")  //CRUD READ | Get the resource with given id
	public ResponseEntity<Accessory> getAccessoryById(@PathVariable int id) {
		Accessory accessory = accessoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Accessory not found."));
				return ResponseEntity.ok(accessory);
	}
	
	@GetMapping("allaccessories/{type}") // 
	public List<Accessory> getaccessoriesByType(@PathVariable String type) {
		List<Accessory> accessories = accessoryRepo.findByType(type);
		if(accessories.isEmpty()) {
			System.out.println(new ResourceNotFoundException("Accessory(s) with the name " + type + " not found."));
		}
		return accessoryRepo.findByType(type);
	}
	
//	Saves a given entity. Create accessory
	@PostMapping("addaccessory") //CRUD CREATE | Used to create a new resource
	public Accessory newAccessory(@RequestBody Accessory accessory) {
		return accessoryRepo.save(accessory);
	}	
	
	@PutMapping("accessory/{id}") //CRUD UPDATE | Updates a resource with given id
	public ResponseEntity<Accessory> updateAccessory(@PathVariable int id, @RequestBody Accessory newAccessoryInfo) {
		Accessory foundAccessory = accessoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Accessory not found."));
		
//		Update info of found accessory using setters with the new info from req.body using getters.
		foundAccessory.setType(newAccessoryInfo.getType());
		foundAccessory.setPrice(newAccessoryInfo.getPrice());
		
		Accessory updatedAccessory = accessoryRepo.save(foundAccessory);
		
		return ResponseEntity.ok(updatedAccessory);
	}
	
//	Use PathVariable to grab the value of {id} parameter from URI
	@DeleteMapping("accessory/{id}") // Deletes the resource with the given id
	public ResponseEntity<String> deleteAccessory(@PathVariable int id) {
//		Find user we want to delete
		accessoryRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Accessory not found."));
		
		String message =  "Accessory has been deleted.";
		
//		Delete method from Jpa. Deletes entity from database.
		accessoryRepo.deleteById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
