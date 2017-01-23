package io.adi_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class BadRequestExecption extends RuntimeException {

	
	private static final long serialVersionUID = 8812385346384652713L;
	
	public BadRequestExecption(String message) {
	   super(message);
	}
	
	public BadRequestExecption(String message, Throwable cause) {
		super(message, cause);
	}

} 
