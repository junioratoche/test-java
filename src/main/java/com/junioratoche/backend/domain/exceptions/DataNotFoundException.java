package com.junioratoche.backend.domain.exceptions;

public class DataNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
        super(message);
    }
}
