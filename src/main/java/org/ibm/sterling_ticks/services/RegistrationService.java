package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.enitities.UserModel;

public interface RegistrationService {

	Boolean addUser(UserModel user);
	
	Boolean deleteUser(UserModel user);

	UserModel getByUserName(String username);

	
}
