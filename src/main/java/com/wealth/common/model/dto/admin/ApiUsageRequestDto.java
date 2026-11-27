package com.wealth.common.model.dto.admin;

import java.io.Serializable;

// How many days of API usage to show, today included: 1 to 30. Empty means 7.
// userId narrows the counts to one user: empty = all users, "me" = the user who is asking, or a user id. Outside calls made by a job and the jobs have no user.
public class ApiUsageRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer days;
	private String userId;

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
