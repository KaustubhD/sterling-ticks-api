package org.ibm.sterling_ticks.model.entities.dto;

import java.util.Date;
import java.util.Set;

public class OrderDto {

	public Integer orderId;
	public Date placedAt;
	public Float voucherDiscount;
	public Set<OrderItemDto> orderItems;
}

class OrderItemDto {
	public Integer orderItemId;
	public ProductDto product;
	public Integer boughtAtPrice;
	public Integer boughtAtDiscount;
	public Integer quantity;
}
