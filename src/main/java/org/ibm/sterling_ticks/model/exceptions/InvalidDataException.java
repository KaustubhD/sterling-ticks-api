package org.ibm.sterling_ticks.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST , reason = "Invalid Parameters")
public class InvalidDataException extends RuntimeException{

	public InvalidDataException(){
		super();
	}
	
	public InvalidDataException(String message){
		super(message);
	}
}
