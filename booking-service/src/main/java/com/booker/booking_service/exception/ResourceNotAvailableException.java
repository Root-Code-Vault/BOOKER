package com.booker.booking_service.exception;

public class ResourceNotAvailableException extends RuntimeException {
	public ResourceNotAvailableException(String message) {
		super(message);
	}
}
