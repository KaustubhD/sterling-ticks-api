package org.ibm.sterling_ticks.services.impl;

import org.ibm.sterling_ticks.model.entities.dto.OtpDto;
import org.ibm.sterling_ticks.model.exceptions.InvalidDataException;
import org.ibm.sterling_ticks.services.MailService;
import org.ibm.sterling_ticks.services.OtpService;
import org.ibm.sterling_ticks.services.TwilioService;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class OtpServiceImpl implements OtpService {

	private static final Integer EXPIRE_MINS = 10;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private TwilioService smsService;
	
	private LoadingCache<String, Integer> otpCache;

	public OtpServiceImpl(){
		super();
		otpCache = CacheBuilder
					.newBuilder()
					.expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
					.build(new CacheLoader<String, Integer>() {
						public Integer load(String key) {
							return 0;
						}
					});
	}
	
	@Override
	public boolean generateOtp(OtpDto dto) {
		if (dto.username.isBlank()) {
			throw new InvalidDataException("No username supplied");
		}
		if (!dto.email.isBlank()) {
			int otp = generateOtp(dto.username);
			mailService.sendOtpMail(dto.email, otp);
		}
		else if (!dto.phone.isBlank()) {
			int otp = generateOtp(dto.username);
			smsService.sendMessage(dto.phone, otp);
		}
		else {
			throw new InvalidDataException("Email or phone required for sending OTP");
		}
		return true;
	}

	@Override
	public boolean validateOtp(OtpDto dto) {
		if (dto.username.isBlank() || dto.value < 1) {
			throw new InvalidDataException("Missing values");
		}
		int otp;
		try {
			otp = getOtp(dto.username);
		} catch(Exception e) {
			return false;
		}
		
		return otp == dto.value;
	}
	
	private int generateOtp(String key) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(key, otp);
		return otp;
	}

	private int getOtp(String key) {
		try {
			return otpCache.get(key);
		} catch (Exception e) {
			return -1;
		}
	}

	private void clearOtp(String key) {
		otpCache.invalidate(key);
	}
}