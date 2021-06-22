package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.entities.dto.UserProfileDto;

public interface UserProfileUpdateService {

	public Boolean updateProfileImage(UserProfileDto user);
}
