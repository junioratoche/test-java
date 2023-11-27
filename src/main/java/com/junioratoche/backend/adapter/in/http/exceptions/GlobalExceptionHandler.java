package com.junioratoche.backend.adapter.in.http.exceptions;

import java.time.format.DateTimeParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.junioratoche.backend.domain.exceptions.DataNotFoundException;
import com.junioratoche.backend.domain.exceptions.InvalidRequestParametersException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<?> handleDateTimeParseException(DateTimeParseException ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Invalid date: " + ex.getMessage(),
				"Invalid date format. Use yyyy-MM-dd-HH.mm.ss format");
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidRequestParametersException.class)
	public ResponseEntity<?> handleInvalidRequestParametersException(InvalidRequestParametersException ex,
			WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), "Invalid parameters");
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ServletRequestBindingException.class)
	public ResponseEntity<ApiError> handleServletRequestBindingException(ServletRequestBindingException ex,
			WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), "Request binding error");
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ApiError> handleDataNotFoundException(DataNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), "No data found");
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
