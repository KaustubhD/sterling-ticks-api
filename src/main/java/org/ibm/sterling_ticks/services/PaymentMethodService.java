package org.ibm.sterling_ticks.services;

import java.util.List;

import org.ibm.sterling_ticks.model.entities.dto.PaymentMethodDto;

public interface PaymentMethodService {
	public List<PaymentMethodDto> getSavedCards(String userName);
	public Integer saveCard(String userName, PaymentMethodDto dto);
	public boolean deleteCard(String userName, Integer cardId);
}
