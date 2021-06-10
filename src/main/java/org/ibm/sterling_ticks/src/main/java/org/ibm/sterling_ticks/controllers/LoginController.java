package org.ibm.sterling_ticks.controllers;

import org.ibm.sterling_ticks.model.enitities.UserModel;
import org.ibm.sterling_ticks.model.exceptions.InvalidCredentialException;
import org.ibm.sterling_ticks.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("")
@RequestMapping("sterling-ticks/")
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/login", consumes = "application/json", produces="application/json")
	public UserModel addUser(@RequestBody UserModel user) {
		if(user.getUserName()!=null&&user.getPassword()!=null) {
			return loginService.login(user.getUserName(), user.getPassword());
		}
		else throw new InvalidCredentialException();
	}
}
