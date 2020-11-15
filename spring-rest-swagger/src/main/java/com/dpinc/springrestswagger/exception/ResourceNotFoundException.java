package com.dpinc.springrestswagger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for Resource not found exception
 * @author Dhruvesh
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Custom exception
	 * @param message - message
	 */
	public ResourceNotFoundException(String message) {
	    super(message);
	}
	
}
