package org.ibm.sterling_ticks.controllers;

import org.ibm.sterling_ticks.model.entities.dto.LoginDto;
import org.ibm.sterling_ticks.model.entities.dto.UserDto;
import org.ibm.sterling_ticks.model.exceptions.InvalidDataException;
import org.ibm.sterling_ticks.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto addUser(@RequestBody LoginDto user) {
		if(user.username != null && user.password != null) {
			return loginService.login(user);
		}
		else throw new InvalidDataException();
	}
}
