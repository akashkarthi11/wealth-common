package com.wealth.common.model.dto.sms;

import java.io.Serializable;

// One SMS from the phone: its id on the phone, the sender name, the text and when it arrived (epoch milliseconds).
public class SmsMessageDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String sender;
	private String body;
	private long at;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getAt() {
		return at;
	}

	public void setAt(long at) {
		this.at = at;
	}
}
