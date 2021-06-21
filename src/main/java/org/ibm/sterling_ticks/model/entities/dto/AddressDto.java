package org.ibm.sterling_ticks.model.entities.dto;

import org.ibm.sterling_ticks.model.entities.enumerations.AddressType;

public class AddressDto {

	public Integer id;
	public String name;
	public AddressType type;
	public boolean isDefault;
	public String address;
	public String city;
	public String state;
	public String country;
	public Integer pincode;
	public String phoneNo;
}
