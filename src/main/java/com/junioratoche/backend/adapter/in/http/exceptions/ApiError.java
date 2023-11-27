package com.junioratoche.backend.adapter.in.http.exceptions;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ApiError {

	private HttpStatus status;
	private String message;
	private String details;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> errors;

	public List<String> getErrors() {
		return errors;
	}

	public ApiError(HttpStatus status, String message, String details) {

		this.status = status;
		this.message = message;
		this.details = details;
	}

	public ApiError(HttpStatus status, String message, String details, List<String> errors) {
		this.status = status;
		this.message = message;
		this.details = details;
		this.errors = errors;
	}

	public ApiError() {

	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}