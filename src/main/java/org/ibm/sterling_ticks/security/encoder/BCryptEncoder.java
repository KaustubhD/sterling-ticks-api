package org.ibm.sterling_ticks.security.encoder;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoder {
	private final int STRENGTH = 10;
	
	public String encode(String plainPassword) {
		SecureRandom salt =  new SecureRandom();
		return encode(plainPassword, salt);
	}
	
	public String encode(String plainPassword, SecureRandom salt) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(STRENGTH, salt);
		return bCryptPasswordEncoder.encode(plainPassword);
	}
	
	public boolean matches(String encoded, String plainText) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(plainText, encoded);
	}
}
