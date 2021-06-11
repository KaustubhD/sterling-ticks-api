package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.entities.UserModel;
import org.ibm.sterling_ticks.model.entities.dto.LoginDto;
import org.ibm.sterling_ticks.model.entities.dto.UserDto;
import org.ibm.sterling_ticks.model.exceptions.InvalidCredentialException;
import org.ibm.sterling_ticks.repositories.UserRepository;
import org.ibm.sterling_ticks.security.encoder.BCryptEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepository repo;
	
	private BCryptEncoder encoder = new BCryptEncoder();

	@Override
	public UserDto login(LoginDto dto) {
		UserModel user = repo.findByUserName(dto.username);
		if(encoder.matches(user.getPassword(), dto.password)) {
			return new UserDto(user);
		}
		else throw new InvalidCredentialException();
	}
}
