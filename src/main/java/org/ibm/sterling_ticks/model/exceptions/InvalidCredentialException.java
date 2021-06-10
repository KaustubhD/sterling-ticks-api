package org.ibm.sterling_ticks.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST , reason = "Invalid Parameters")
public class InvalidCredentialException extends RuntimeException {

	public InvalidCredentialException(){
		super();
	}
	
	public InvalidCredentialException(String message){
		super(message);
	}
}
