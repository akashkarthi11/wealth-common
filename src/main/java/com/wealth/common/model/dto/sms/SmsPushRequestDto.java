package com.wealth.common.model.dto.sms;

import java.io.Serializable;
import java.util.List;

// What the phone app sends: the phone token (in the body, never in an address) and up to 50 messages.
public class SmsPushRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;
	private List<SmsMessageDto> messages;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<SmsMessageDto> getMessages() {
		return messages;
	}

	public void setMessages(List<SmsMessageDto> messages) {
		this.messages = messages;
	}
}
