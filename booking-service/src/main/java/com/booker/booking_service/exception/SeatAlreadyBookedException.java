package com.booker.booking_service.exception;

import java.util.Map;

public class SeatAlreadyBookedException extends RuntimeException {
	private final Map<String, String> details;

	public SeatAlreadyBookedException(String message, Map<String, String> details) {
		super(message);
		this.details = details;

	}

	public Map<String, String> getDetails() {
		return details;
	}

}
