package com.wealth.common.generic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wealth.common.logger.KarthiLogger;

// KarthiException becomes an ApiResponse with status 0 and the error code (HTTP 202, as in GrowX).
@RestControllerAdvice
public class RestControllerExceptionHandler {

	private static final KarthiLogger LOGGER = new KarthiLogger(RestControllerExceptionHandler.class);

	@ExceptionHandler(KarthiException.class)
	public ResponseEntity<ApiResponse<Void, Void>> handleKarthiException(KarthiException ex) {
		LOGGER.warn("KarthiException | code=" + ex.getMessage());
		ApiResponse<Void, Void> response = new ApiResponse<>();
		response.setData(null);
		response.setErrorCode(ex.getMessage());
		response.setErrorMessage(BaseError.getConstantNameByValue(ex.getMessage()));
		response.setStatus(0);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}
}
