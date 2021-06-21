package org.ibm.sterling_ticks.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.ibm.sterling_ticks.model.entities.AddressModel;
import org.ibm.sterling_ticks.model.entities.UserModel;
import org.ibm.sterling_ticks.model.entities.dto.AddressDto;
import org.ibm.sterling_ticks.model.entities.dto.UserProfileDto;
import org.ibm.sterling_ticks.repositories.AddressRepository;
import org.ibm.sterling_ticks.repositories.UserRepository;
import org.ibm.sterling_ticks.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserProfileDto getUserDetails(String userName) {
		UserModel entity = userRepo.findByUserName(userName);
		return mapper.map(entity, UserProfileDto.class);
	}

	@Override
	public List<AddressDto> getUserAddresses(String userName) {
		UserModel entity = userRepo.findByUserName(userName);
		return entity.getSavedAddresses().stream().map(addEnt -> mapper.map(addEnt, AddressDto.class)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public boolean saveAddress(AddressDto dto, String userName) {
		UserModel userEntity = userRepo.findByUserName(userName);
		AddressModel addEntity = editOrCreateAddress(userEntity, dto);
		if(addEntity.isDefault()) {
			this.setAllAddressNotDefault(userEntity);
			addEntity.setDefault(true);
		}
		return true;
	}
	@Override
	@Transactional
	public boolean deleteUserAddress(String userName, Integer addressId) {
		UserModel userEntity = userRepo.findByUserName(userName);
		AddressModel address = userEntity.getSavedAddresses().stream().filter(add -> add.getAddressId() == addressId).findFirst().orElse(null);
		if (address == null) {
			return false;
		}
		unlinkAddressToUser(userEntity, address);
		return true;
	}
	private AddressModel editOrCreateAddress(UserModel user, AddressDto dto) {
		AddressModel addEntity = null;
		if(dto.addressId != null && dto.addressId > 0) {
			addEntity = user.getSavedAddresses()
							.stream()
							.filter(add -> add.getAddressId() == dto.addressId)
							.findFirst()
							.orElse(null);
		}
		if(addEntity == null) {
			addEntity = mapper.map(dto, AddressModel.class);
			addEntity = addressRepo.save(addEntity);
			linkAddressToUser(user, addEntity);
		}
		else {
			mapper.map(dto, addEntity);
		}
		return addEntity;
	}
	
	private void setAllAddressNotDefault(UserModel user) {
		user.getSavedAddresses().stream().forEach(add -> add.setDefault(false));
	}
	private void linkAddressToUser(UserModel user, AddressModel address) {
		user.getSavedAddresses().add(address);
		userRepo.save(user);
		address.setUser(user);
	}
	private void unlinkAddressToUser(UserModel user, AddressModel address) {
		user.getSavedAddresses().remove(address);
		address.setUser(null);
	}


}
