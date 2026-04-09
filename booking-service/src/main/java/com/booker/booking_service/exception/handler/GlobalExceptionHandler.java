package com.booker.booking_service.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.booker.booking_service.exception.ItemNotFoundException;
import com.booker.booking_service.exception.OperationFailedException;
import com.booker.booking_service.exception.ResourceNotAvailableException;
import com.booker.booking_service.exception.SeatNotReservedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleProductNotFoundException(ItemNotFoundException exception) {
		Map<String, String> error = new HashMap<String, String>();
		error.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(ResourceNotAvailableException.class)
	public ResponseEntity<Map<String, String>> handleResourceNotAvailableException(ResourceNotAvailableException exception) {
		Map<String, String> error = new HashMap<String, String>();
		error.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
	}
	
	@ExceptionHandler(OperationFailedException.class)
	public ResponseEntity<Map<String, String>> handleOperationFailedException(OperationFailedException exception) {
		Map<String, String> error = new HashMap<String, String>();
		error.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error);
	}
	
	@ExceptionHandler(SeatNotReservedException.class)
	public ResponseEntity<Map<String, String>> handleSeatNotReservedException(SeatNotReservedException exception) {
		Map<String, String> error = new HashMap<String, String>();
		error.put("message", exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
