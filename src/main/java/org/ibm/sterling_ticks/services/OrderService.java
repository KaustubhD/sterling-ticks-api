package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.entities.dto.CartDto;
import org.ibm.sterling_ticks.model.entities.dto.CartRequestDto;

public interface OrderService {

	public Integer updateOrderItems(CartRequestDto item);
	public CartDto getUserCart(String username);
	public Integer getQuantityInCart(String userName, String modelNo);
}
