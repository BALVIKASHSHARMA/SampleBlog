package com.ecart.bbva.constant;

public enum NoRecordsError {

	EMPTY_RESPONSE("001", "No records found");

	private String code;
	private String message;

	private NoRecordsError(String code, String message) {
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
