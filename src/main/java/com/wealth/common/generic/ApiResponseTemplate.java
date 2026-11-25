package com.wealth.common.generic;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

// Standard success envelope (growx-common-lib ApiResponseTemplate): status 1, errorCode "Success".
@Component
public class ApiResponseTemplate {

	public <T> ResponseEntity<ApiResponse<T, Void>> apires(T data, String errorCode) {
		ApiResponse<T, Void> res = new ApiResponse<>();
		res.setData(data);
		res.setStatus(1);
		res.setErrorCode(errorCode);
		res.setErrorMessage(BaseError.getConstantNameByValue(errorCode));
		return ResponseEntity.ok(res);
	}

	public <T, M> ResponseEntity<ApiResponse<T, M>> apires(T data, String errorCode, M meta) {
		ApiResponse<T, M> res = new ApiResponse<>();
		res.setData(data);
		res.setStatus(1);
		res.setErrorCode(errorCode);
		res.setErrorMessage(BaseError.getConstantNameByValue(errorCode));
		res.setMeta(meta);
		return ResponseEntity.ok(res);
	}
}
