package org.ibm.sterling_ticks.model.entities.dto;

import java.util.Date;
import java.util.Set;

import org.ibm.sterling_ticks.model.entities.RoleModel;
import org.ibm.sterling_ticks.model.entities.UserModel;

public class UserDto {
	public String userName;
	public String email;
	public Date dateCreated;
	public String phoneNo;
	public Set<RoleModel> roles;
	public String userImage;
	
	public UserDto(UserModel model) {
		userName = model.getUserName();
		email = model.getEmail();
		dateCreated = model.getDateCreated();
		phoneNo = model.getPhoneNo();
		userImage = model.getImage();
		roles = model.getRoles();
	}
}
