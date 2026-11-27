package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// One user who has API usage in the period, for the user choice on the screen. calls = the website calls (BFF APIs) that user made.
public class ApiUsageUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;
	// Empty when the user no longer exists.
	private String email;
	private long calls;
	// True for the user who is asking.
	private boolean me;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCalls() {
		return calls;
	}

	public void setCalls(long calls) {
		this.calls = calls;
	}

	public boolean isMe() {
		return me;
	}

	public void setMe(boolean me) {
		this.me = me;
	}
}
