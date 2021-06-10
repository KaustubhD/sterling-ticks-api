package org.ibm.sterling_ticks.services;

import java.util.Date;

import org.ibm.sterling_ticks.model.enitities.UserModel;
import org.ibm.sterling_ticks.model.exceptions.InvalidDataException;
import org.ibm.sterling_ticks.repositories.UserRepository;
import org.ibm.sterling_ticks.security.encoder.BCryptEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UserRepository repo;

	@Override
	public Boolean addUser(UserModel user) throws InvalidDataException {
		BCryptEncoder encoder = new BCryptEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setDateCreated(new Date());
		try {
			repo.save(user);
			return true;
		} catch (Exception e) {
			throw new InvalidDataException();
		}
	}

	@Override
	public Boolean deleteUser(UserModel user) {
		if (repo.findById(user.getId()) != null) {
			repo.delete(user);
			return true;
		}
		return false;
	}
}
