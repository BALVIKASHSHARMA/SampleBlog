package com.ecart.bbva.exteption;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -9221507505422376857L;

	public BusinessException() {
		super();

	}

	public BusinessException(String message,
			Throwable cause,
			boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression,
				writableStackTrace);

	}

	public BusinessException(String message,
			Throwable cause) {
		super(message, cause);

	}

	public BusinessException(String message) {
		super(message);

	}

	public BusinessException(Throwable cause) {
		super(cause);

	}

}
