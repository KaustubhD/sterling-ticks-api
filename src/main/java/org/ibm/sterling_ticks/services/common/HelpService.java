package org.ibm.sterling_ticks.services.common;

import java.util.Optional;

import org.ibm.sterling_ticks.model.entities.OrderItemModel;
import org.ibm.sterling_ticks.model.entities.OrderModel;
import org.springframework.stereotype.Service;

@Service
public class HelpService {

	public Optional<OrderItemModel> getOrderItemByProductId(OrderModel order, Integer productId) {
		if(order == null)
			return Optional.empty();
		
		return order.getOrderItems()
				.stream().filter((orderItem) -> orderItem.getProduct().getProductId() == productId)
				.findFirst();
	}
	public Optional<OrderItemModel> getOrderItemByModelNo(OrderModel order, String modelNo) {
		if(order == null)
			return Optional.empty();
		
		return order.getOrderItems()
				.stream().filter((orderItem) -> orderItem.getProduct().getModelNo().equals(modelNo))
				.findFirst();
	}
}
