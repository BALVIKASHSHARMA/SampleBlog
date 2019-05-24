package com.ecart.bbva.exteption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ServiceError> controlserviceException(final ServiceException e) {
		ServiceError error = new ServiceError();
		error.setErrorCode(e.getErrorCode());
		error.setMessage(e.getErrorMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
