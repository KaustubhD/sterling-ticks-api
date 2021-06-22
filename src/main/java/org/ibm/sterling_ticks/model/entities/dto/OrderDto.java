package org.ibm.sterling_ticks.model.entities.dto;

import java.util.Date;
import java.util.Set;

import org.ibm.sterling_ticks.model.entities.enumerations.Status;

public class OrderDto {

	public Integer orderId;
	public Date placedAt;
	public Float voucherDiscount;
	public Status orderStatus;
	public Set<OrderItemDto> orderItems;
	public TransactionDto transactions;
	public AddressDto address;
}

class OrderItemDto {
	public Integer orderItemId;
	public ProductDto product;
	public Integer boughtAtPrice;
	public Integer boughtAtDiscount;
	public Integer quantity;
}

class TransactionDto {
	public Float price;
}
