package com.wealth.common.generic;

public class GrowxException extends RuntimeException {

	private String errorCode;

	public GrowxException(String message) {
		super(message);
	}

	public GrowxException(String message, Throwable cause) {
		super(message, cause);
	}

	public GrowxException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public GrowxException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
