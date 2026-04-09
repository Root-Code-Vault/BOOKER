package com.booker.booking_service.exception;

public class SeatNotReservedException extends RuntimeException {
	public SeatNotReservedException(String message) {
		super(message);
	}
}
