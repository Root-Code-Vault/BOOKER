package com.booker.auth_service.exception;

public class UserIdAlreadyExistsException extends RuntimeException {
	public UserIdAlreadyExistsException (String message) {super(message);}
}
