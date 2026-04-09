package com.booker.auth_service.exception;

public class MobileAlreadyExistsException extends RuntimeException {
	public MobileAlreadyExistsException(String message) {
		super(message);
	}	
}
