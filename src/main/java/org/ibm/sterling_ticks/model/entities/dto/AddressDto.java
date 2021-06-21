package org.ibm.sterling_ticks.model.entities.dto;

import org.ibm.sterling_ticks.model.entities.enumerations.AddressType;

public class AddressDto {

	public Integer addressId;
	public String name;
	public AddressType type;
	public boolean isDefault;
	public String address;
	public String state;
	public String country;
	public int pin;
}
