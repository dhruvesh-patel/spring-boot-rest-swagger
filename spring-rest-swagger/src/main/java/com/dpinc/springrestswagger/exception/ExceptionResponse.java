package com.dpinc.springrestswagger.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Exception response object 
 * 
 * @author Dhruvesh
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionResponse {

	 private String errorMessage;
	 private String errorDetails;
	 private String status;
	 private Date timestamp;
	  
}
