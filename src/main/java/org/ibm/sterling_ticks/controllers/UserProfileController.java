package org.ibm.sterling_ticks.controllers;

import org.ibm.sterling_ticks.model.entities.dto.UserProfileDto;
import org.ibm.sterling_ticks.services.UserProfileUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserProfileController {
	
	@Autowired
	UserProfileUpdateService service;
	
	@PutMapping(value="update", consumes="application/json", produces="application/json")
	public ResponseEntity<?> updateProfileImage(@RequestBody UserProfileDto user) {
		Boolean response = service.updateProfileImage(user);
		return ResponseEntity.ok(response);
	}
}
