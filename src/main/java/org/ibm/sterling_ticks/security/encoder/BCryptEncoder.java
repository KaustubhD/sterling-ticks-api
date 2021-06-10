package org.ibm.sterling_ticks.security.encoder;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoder {
	private int strength = 10;
	
	public String encode(String plainPassword) {
		SecureRandom salt =  new SecureRandom();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, salt);
		return bCryptPasswordEncoder.encode(plainPassword);
	}
	
	public String encode(String plainPassword, SecureRandom salt) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, salt);
		return bCryptPasswordEncoder.encode(plainPassword);
	}
}
