package com.ecommerce.Search.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SearchExceptionHandler {
	
	// Add an exception handler for CustomException
	
		@ExceptionHandler
		public ResponseEntity<SearchErrorResponse> handleException(CustomException exc) {
			
			// create SearchErrorResponse
			
			SearchErrorResponse error = new SearchErrorResponse(
												HttpStatus.NOT_FOUND.value(),
												exc.getMessage(),
												System.currentTimeMillis());
			
			// return ResponseEntity
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
		
		// Add another exception handler ... to catch any exception (catch all)

	
	@ExceptionHandler
	public ResponseEntity<SearchErrorResponse> handleException(Exception exc) {
		
		// create SearchErrorResponse
		
		SearchErrorResponse error = new SearchErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	


}
