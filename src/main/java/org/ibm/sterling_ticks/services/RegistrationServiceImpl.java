package org.ibm.sterling_ticks.services;

import java.security.SecureRandom;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import org.ibm.sterling_ticks.model.enitities.UserModel;
import org.ibm.sterling_ticks.repositories.UserRepository;
import org.ibm.sterling_ticks.security.encoder.BCryptEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public Boolean addUser(UserModel user) {
		if(user.getEmail()!=null&&user.getUserName()!=null&&user.getPassword()!=null) {
			BCryptEncoder encoder = new BCryptEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			user.setDateCreated(new Date());
			repo.save(user);

			return true;	
		}
		return false;

	}

	@Override
	public Boolean deleteUser(UserModel user) {
		// TODO Auto-generated method stub
		if(repo.findById(user.getId()) != null) {
			repo.delete(user);
			return true;
		}
		return false;
	}

	@Override
	public UserModel getByUserName(String username) {
		// TODO Auto-generated method stub
		return repo.findByUserName(username);
	}

	

}
