package com.solidware.project.person.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, reason="Group Out Of Bound")
public class GroupOutOfBoundException extends RuntimeException {

	private static final long serialVersionUID = -8790211652911971727L;
	
	public GroupOutOfBoundException(String msg) { 
		super(msg + "Group Out Of Bound"); 		
	} 

}
