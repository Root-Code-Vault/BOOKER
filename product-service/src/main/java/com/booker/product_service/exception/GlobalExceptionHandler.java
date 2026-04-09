package com.booker.product_service.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5320605762605776609L;
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
		Map<String, String> error = new HashMap<String, String>();

		error.put("error", "Internal Server Error " + ex.getMessage());
		log.error(ex.getMessage());
		return ResponseEntity.internalServerError().body(error);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleRecordNotFoundException(RecordNotFoundException ex) {
		log.warn(ex.getMessage());
		
		Map<String, String> error = new HashMap<String, String>();
		error.put("message", ex.getMessage());
			
		return ResponseEntity.badRequest().body(error);
	}

}
