package com.booker.seat_service.exception;

public class SeatNotFoundException extends RuntimeException {
	public SeatNotFoundException(Long seatId) {
        super("Seat with ID " + seatId + " not found");
    }
}
