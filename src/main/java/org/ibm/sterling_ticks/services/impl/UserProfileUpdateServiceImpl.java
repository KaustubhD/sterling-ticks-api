package org.ibm.sterling_ticks.services.impl;

import org.ibm.sterling_ticks.model.entities.UserModel;
import org.ibm.sterling_ticks.model.entities.dto.UserProfileDto;
import org.ibm.sterling_ticks.repositories.UserRepository;
import org.ibm.sterling_ticks.services.UserProfileUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileUpdateServiceImpl implements UserProfileUpdateService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Boolean updateProfileImage(UserProfileDto user) {
		UserModel entity = userRepo.findByUserName(user.userName);
		System.out.println(entity);
		if(entity!=null) {
			entity.setImage(user.userImage);
			userRepo.save(entity);
			return true;
		}
		else
			return false;
	}

}
