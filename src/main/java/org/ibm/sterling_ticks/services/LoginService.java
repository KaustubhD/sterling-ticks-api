package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.entities.UserModel;

public interface LoginService {

	UserModel login(String username, String password);
}
