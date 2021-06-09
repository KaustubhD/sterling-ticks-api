package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.enitities.UserModel;
import org.ibm.sterling_ticks.model.exceptions.InvalidCredentialException;
import org.ibm.sterling_ticks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepository repo;

	//NEEDS TO BE UPDATED
	@Override
	public UserModel login(String username, String password) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.getPrincipal().equals("anonymousUser")) {
			return repo.findByUserName(username);
		}
		else throw new InvalidCredentialException();
	}
}
