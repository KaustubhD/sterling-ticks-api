package org.ibm.sterling_ticks.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioService {

	@Value("${twilio.account_sid}")
	private String ACCOUNT_SID;
	
	@Value("${twilio.auth_token}")
	private String AUTH_TOKEN;
	
	@Value("${twilio.number}")
	private String TWILIO_NUMBER;
	
	private final String INDIA_PREFIX = "+91";
	
	private final String MESSAGE_TEMPLATE = "Your OTP for verification for Sterling Ticks is %s. It is valid for 10 minutes.";
	
	public void sendMessage(String phone, int otp) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message.creator(
		    new PhoneNumber(INDIA_PREFIX + phone),
		    new PhoneNumber(TWILIO_NUMBER),
		    String.format(MESSAGE_TEMPLATE, String.valueOf(otp)))
		.create();
	}
}
