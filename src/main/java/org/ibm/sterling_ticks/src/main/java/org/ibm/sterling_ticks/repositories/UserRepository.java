package org.ibm.sterling_ticks.repositories;

import org.ibm.sterling_ticks.model.enitities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

	UserModel findByEmail(String email);
	
	UserModel findByUserName(String username);
}
