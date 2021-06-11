package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.entities.dto.LoginDto;
import org.ibm.sterling_ticks.model.entities.dto.UserDto;

public interface LoginService {

	UserDto login(LoginDto dto);
}
