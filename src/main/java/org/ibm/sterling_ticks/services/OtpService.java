package org.ibm.sterling_ticks.services;

import org.ibm.sterling_ticks.model.entities.dto.OtpDto;

public interface OtpService {
	public boolean generateOtp(OtpDto dto);
	public boolean validateOtp(OtpDto dto);
}
