package com.wealth.common.generic;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ApiResponse<T, M> {
	private T data;

	private int status;
	private String errorCode;
	private String errorMessage;
	private M meta;

	public ApiResponse() {
		super();
		this.status = HttpStatus.OK.value();

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}



	public M getMeta() {
		return meta;
	}

	public void setMeta(M meta) {
		this.meta = meta;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
