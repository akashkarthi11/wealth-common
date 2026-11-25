package com.wealth.common.utils.generic;

import java.nio.charset.StandardCharsets;

import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.wealth.common.generic.ApiResponse;
import com.wealth.common.generic.GrowxException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken; // For TypeToken

import java.io.IOException;
import java.lang.reflect.Type; // For Type interface
import feign.Util; // For feign.Util
import java.nio.charset.StandardCharsets; // For StandardCharsets
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

public class MyCustomErrorDecoder implements ErrorDecoder {
	@Override
	public Exception decode(String methodKey, Response response) {

		//if (response.status() == 410) {
		if (response.status() != 200) {
			String bodyString = null;
			try {
				bodyString = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			Gson gson = new Gson();
			Type responseType = new TypeToken<ApiResponse<Void, Void>>() {
			}.getType();

			ApiResponse<Void, Void> apiResponse = gson.fromJson(bodyString, responseType);
			
		
			return new GrowxException(apiResponse.getErrorCode());
				
			}
		
		return null;

	}
}