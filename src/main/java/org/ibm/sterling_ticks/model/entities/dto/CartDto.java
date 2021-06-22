package org.ibm.sterling_ticks.model.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDto {

	public String userName;
	public List<CartItemDto> orderItems = new ArrayList<>();
}

class CartItemDto {
	public ProductDto product;
	public Integer quantity;
}