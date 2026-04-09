package com.booker.seat_service.exception;

public class SeatAlreadyBookedException extends RuntimeException{
	public SeatAlreadyBookedException(Long seatId) {
        super("Seat with ID " + seatId + " is already booked");
    }
}
