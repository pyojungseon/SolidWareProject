package com.solidware.project.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, reason="Not Satisfied Length")
public class PersonLengthException extends RuntimeException {

	private static final long serialVersionUID = -8790211652911971729L;
	
	public PersonLengthException(String msg) { 
		super(msg + "Not Satisfied Length"); 		
	} 

}
