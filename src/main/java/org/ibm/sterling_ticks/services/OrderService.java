package org.ibm.sterling_ticks.services;

import java.util.List;
import org.ibm.sterling_ticks.model.entities.dto.CartDto;
import org.ibm.sterling_ticks.model.entities.dto.CartRequestDto;
import org.ibm.sterling_ticks.model.entities.dto.CartVoucherDto;
import org.ibm.sterling_ticks.model.entities.dto.OrderDto;
import org.ibm.sterling_ticks.model.entities.dto.OrderPlaceDto;

public interface OrderService {

	public Integer updateOrderItems(CartRequestDto item);
	public CartDto getUserCart(String username);
	public Integer getQuantityInCart(String userName, String modelNo);
	public boolean addVoucherToCart(CartVoucherDto dto);
	public boolean placeOrder(OrderPlaceDto dto);
	public List<OrderDto> getAllOrders(String userName);
}
