package org.ibm.sterling_ticks.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.ibm.sterling_ticks.model.entities.enumerations.AddressType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "saved_address")
public class AddressModel {
	@Id
	@GeneratedValue
	@Column(name = "address_id")
	private Integer addressId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@JsonBackReference
	private UserModel user;
	
	@Column(unique = true)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private AddressType type = AddressType.home;
	
	private boolean isDefault;
	
	private String address;
	
	private String state;
	
	private String city;
	
	private String country;
	
	@Column(name = "pin", length = 6)
	private Integer pincode;
	
	@Column(length = 10)
	private String phoneNo;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(Integer pin) {
		this.pincode = pin;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phone) {
		this.phoneNo = phone;
	}
}
