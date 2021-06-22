package org.ibm.sterling_ticks.model.entities.dto;

import java.util.Date;

public class PaymentMethodDto {

	public Integer paymentMethodId;
	public String nameOnCard;
	public String cardNumber;
	public Date expiry;
	public Integer cvvNo;
}
