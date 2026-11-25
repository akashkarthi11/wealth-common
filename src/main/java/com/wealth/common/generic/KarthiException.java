package com.wealth.common.generic;

public class KarthiException extends RuntimeException {

	private String errorCode;

	public KarthiException(String message) {
		super(message);
	}

	public KarthiException(String message, Throwable cause) {
		super(message, cause);
	}

	public KarthiException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public KarthiException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
