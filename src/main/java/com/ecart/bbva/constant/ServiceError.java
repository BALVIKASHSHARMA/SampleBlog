package com.ecart.bbva.constant;

public enum ServiceError {

	NOT_SAVED("002", "No records found"), NOT_UPDATED("003", "No records found"), NOT_DELETED("004",
			"No records found");

	private String code;
	private String message;

	private ServiceError(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
