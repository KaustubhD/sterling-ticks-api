package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.enitities.UserModel;

public interface LoginService {

	UserModel login(String username, String password);
}
