package org.ibm.sterling_ticks.controllers;

import org.ibm.sterling_ticks.model.enitities.UserModel;
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



@RestController("")
@RequestMapping("sterling-ticks/")
@CrossOrigin
class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	
	@PostMapping(value = "/register", consumes = "application/json", produces="application/json")
	public void addUser(@RequestBody UserModel user) {
		registrationService.addUser(user);
	}
	
//	@GetMapping(value = "/{userName}", produces = "application/json")
//	public UserModel getUser(@PathVariable("userName") String username){
//		return registrationService.getByUserName(username);
//	}
	
}