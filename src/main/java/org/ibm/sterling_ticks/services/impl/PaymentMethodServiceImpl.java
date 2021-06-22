package org.ibm.sterling_ticks.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.ibm.sterling_ticks.model.entities.PaymentMethodModel;
import org.ibm.sterling_ticks.model.entities.UserModel;
import org.ibm.sterling_ticks.model.entities.dto.PaymentMethodDto;
import org.ibm.sterling_ticks.repositories.PaymentMethodRepository;
import org.ibm.sterling_ticks.repositories.UserRepository;
import org.ibm.sterling_ticks.services.PaymentMethodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

	@Autowired
	private PaymentMethodRepository methodRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<PaymentMethodDto> getSavedCards(String userName) {
		UserModel savedUser = userRepo.findByUserName(userName);
		if(savedUser == null)
			return null;
		return savedUser.getSavedPaymentMethods()
				.stream()
				.map(method -> mapper.map(method, PaymentMethodDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public boolean saveCard(String userName, PaymentMethodDto dto) {
		UserModel userEntity = userRepo.findByUserName(userName);
		PaymentMethodModel addEntity = editOrCreateCard(userEntity, dto);
		return true;
	}
	
	@Override
	@Transactional
	public boolean deleteCard(String userName, Integer cardId) {
		UserModel userEntity = userRepo.findByUserName(userName);
		PaymentMethodModel card = userEntity.getSavedPaymentMethods().stream().filter(add -> add.getPaymentMethodId() == cardId).findFirst().orElse(null);
		if (card == null) {
			return false;
		}
		unlinkCardToUser(userEntity, card);
		return true;
	}
	
	private PaymentMethodModel editOrCreateCard(UserModel user, PaymentMethodDto dto) {
		PaymentMethodModel addEntity = null;
		if(dto.paymentMethodId != null && dto.paymentMethodId > 0) {
			addEntity = user.getSavedPaymentMethods()
							.stream()
							.filter(card -> card.getPaymentMethodId() == dto.paymentMethodId)
							.findFirst()
							.orElse(null);
		}
		if(addEntity == null) {
			addEntity = mapper.map(dto, PaymentMethodModel.class);
			addEntity = methodRepo.save(addEntity);
			linkCardToUser(user, addEntity);
		}
		else {
			mapper.map(dto, addEntity);
		}
		return addEntity;
	}
	
	private void linkCardToUser(UserModel user, PaymentMethodModel card) {
		user.getSavedPaymentMethods().add(card);
		userRepo.save(user);
		card.setUser(user);
	}
	private void unlinkCardToUser(UserModel user, PaymentMethodModel card) {
		user.getSavedPaymentMethods().remove(card);
		card.setUser(null);
	}

}
