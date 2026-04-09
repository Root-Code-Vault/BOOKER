package com.booker.seat_service.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.booker.seat_service.exception.SeatAlreadyBookedException;
import com.booker.seat_service.exception.SeatNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(SeatNotFoundException.class)
	public ResponseEntity<String> handleSeatNotFound(SeatNotFoundException ex) {
		log.warn(ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(SeatAlreadyBookedException.class)
	public ResponseEntity<String> handleSeatAlreadyBooked(SeatAlreadyBookedException ex) {
		log.warn(ex.getMessage());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneric(Exception ex) {
		log.warn(ex.getMessage());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error: " + ex.getMessage());
	}
}
