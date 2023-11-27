package com.junioratoche.backend.domain.exceptions;

public class InvalidRequestParametersException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidRequestParametersException(String message) {
		super(message);
	}	
}
