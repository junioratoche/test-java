package com.junioratoche.backend.domain.exceptions;

public class UnavailableDateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnavailableDateException(String message) {
		super(message);
	}
}