package org.ibm.sterling_ticks.model.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.ibm.sterling_ticks.model.entities.enumerations.Status;

@Entity
@Table(name = "order_")
public class OrderModel {
	
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Integer orderId;
	
	@OneToOne(optional = true)
	@JoinColumn(name = "address_id")
	private AddressModel address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserModel user;
	
	@Column(name = "placed_at")
	private Date placedAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status orderStatus;

	@Column(name = "voucher_discount")
	private Float voucherDiscount;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderItemModel> orderItems = new HashSet<OrderItemModel>();
	
	@OneToOne
	@JoinColumn(name = "transaction_id")
	private TransactionModel transactions;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public Date getPlacedAt() {
		return placedAt;
	}

	public void setPlacedAt(Date placedAt) {
		this.placedAt = placedAt;
	}

	public Status getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}

	public TransactionModel getTransactions() {
		return transactions;
	}

	public void setTransactions(TransactionModel transactions) {
		this.transactions = transactions;
	}
	
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Float getVoucherDiscount() {
		return voucherDiscount;
	}

	public void setVoucherDiscount(Float voucherDiscount) {
		this.voucherDiscount = voucherDiscount;
	}

	public Set<OrderItemModel> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItemModel> orderItems) {
		this.orderItems = orderItems;
	}
}
