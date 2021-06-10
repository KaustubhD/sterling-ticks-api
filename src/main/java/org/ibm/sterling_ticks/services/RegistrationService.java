package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.entities.UserModel;
import org.ibm.sterling_ticks.model.exceptions.InvalidDataException;

public interface RegistrationService {

	Boolean addUser(UserModel user) throws InvalidDataException;
	
	Boolean deleteUser(UserModel user);

}
