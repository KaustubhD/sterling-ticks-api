package org.ibm.sterling_ticks.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "saved_address")
public class AddressModel {
	@Id
	@GeneratedValue
	@Column(name = "address_id")
	public int addressId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	public UserModel user;
	
	public String name;
	
	public String type;
	
	public String address;
	
	public String state;
	
	public String city;
	
	public String country;
	
	public int pin;
}
