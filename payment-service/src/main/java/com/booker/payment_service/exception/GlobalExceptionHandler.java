package com.booker.payment_service.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleRecordNotFoundException(RecordNotFoundException exception) {
		Map<String, String> error = new HashMap<String, String>();
		error.put("MESSAGE", exception.getMessage());

		log.warn(exception.getMessage());
		
		return ResponseEntity.badRequest().body(error);
	}
}
