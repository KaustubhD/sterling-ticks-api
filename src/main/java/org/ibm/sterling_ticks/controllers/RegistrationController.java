package org.ibm.sterling_ticks.controllers;

import org.ibm.sterling_ticks.model.entities.UserModel;
import org.ibm.sterling_ticks.model.exceptions.InvalidDataException;
import org.ibm.sterling_ticks.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	
	@PostMapping(value = "/register", consumes = "application/json", produces="application/json")
	public void addUser(@RequestBody UserModel user) throws InvalidDataException {
			registrationService.addUser(user);
	}
	

}