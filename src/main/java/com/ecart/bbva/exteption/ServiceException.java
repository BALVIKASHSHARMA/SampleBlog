package com.ecart.bbva.exteption;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 2374605416152121573L;

	private String errorCode;
	private String errorMessage;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String code, String message, Throwable cause) {
		super(message, cause);
		errorCode = code;
		errorMessage = message;
	}

	public ServiceException(String code, String message) {
		super(message);
		errorCode = code;
		errorMessage = message;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
