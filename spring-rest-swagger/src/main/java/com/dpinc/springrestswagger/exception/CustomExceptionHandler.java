package com.dpinc.springrestswagger.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Custom Exception handler
 * @author Dhruvesh
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

	/**
	 * Custom exception handler for Resource not found exception
	 * @param ex - Resource not found exception
	 * @param request - request
	 * @return ResponseEntity<?> - ResponseEntity with HTTP status code 404
	 */
	  @ExceptionHandler(ResourceNotFoundException.class)
	  public ResponseEntity<?> resourceNotFoundException(
	      ResourceNotFoundException ex, WebRequest request) {
	    ExceptionResponse exResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false), 
	        		HttpStatus.NOT_FOUND.toString(), new Date());
	    return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
	  }

	  
	  /**
	   * Custom exception for all Exceptions
	   * @param ex - Exception 
	   * @param request - request
       * @return ResponseEntity<?> - ResponseEntity with HTTP status code 404
	   */
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
	    ExceptionResponse exResponse =
	        new ExceptionResponse(ex.getMessage(), request.getDescription(false), 
	        		HttpStatus.INTERNAL_SERVER_ERROR.toString(), new Date());
	    return new ResponseEntity<>(exResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
}
