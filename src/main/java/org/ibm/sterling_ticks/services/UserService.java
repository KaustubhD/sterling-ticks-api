package org.ibm.sterling_ticks.services;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.dto.AddressDto;
import org.ibm.sterling_ticks.model.entities.dto.UserProfileDto;

public interface UserService {
	public UserProfileDto getUserDetails(String userName);
	public List<AddressDto> getUserAddresses(String userName);
	public boolean saveAddress(AddressDto dto, String userName);
	public boolean deleteUserAddress(String userName, Integer addressId);
}
