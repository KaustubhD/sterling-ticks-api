package org.ibm.sterling_ticks.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "order_item")
public class OrderItemModel {
	
	@Id
	@GeneratedValue
	@Column(name = "order_item_id")
	private Integer orderItemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private OrderModel order;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private ProductModel product;
	
	private Integer quantity;
	
	private Integer boughtAtPrice;
	
	private Float boughtAtDiscount;

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public OrderModel getOrder() {
		return order;
	}

	public void setOrder(OrderModel order) {
		this.order = order;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getBoughtAtPrice() {
		return boughtAtPrice;
	}

	public void setBoughtAtPrice(Integer boughtAtPrice) {
		this.boughtAtPrice = boughtAtPrice;
	}

	public Float getBoughtAtDiscount() {
		return boughtAtDiscount;
	}

	public void setBoughtAtDiscount(Float boughtAtDiscount) {
		this.boughtAtDiscount = boughtAtDiscount;
	}
}
