package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// API usage for the admin screen, most used first. Counts not saved yet are included.
// bff and bss: our own APIs, counted at the BFF (what the website calls) and at the BSS (what the BFF calls). external: the third-party APIs we call, with the
// calls made by a scheduled job listed apart (the name ends with "(job <name>)"). jobs: the scheduled jobs themselves (calls = runs, success = worked).
public class ApiUsageDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int days;
	// When the counts were last saved to the database by this BSS (empty until the first save after a start).
	private Timestamp savedAt;
	private List<ApiUsageRowDto> bff = new ArrayList<>();
	private List<ApiUsageRowDto> bss = new ArrayList<>();
	private List<ApiUsageRowDto> external = new ArrayList<>();
	private List<ApiUsageRowDto> jobs = new ArrayList<>();
	// Everyone with usage in the period, most calls first, for the user choice. Not narrowed by the user asked for.
	private List<ApiUsageUserDto> users = new ArrayList<>();
	// The user the counts are narrowed to; empty for all users.
	private String userId = "";

	public List<ApiUsageUserDto> getUsers() {
		return users;
	}

	public void setUsers(List<ApiUsageUserDto> users) {
		this.users = users;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Timestamp getSavedAt() {
		return savedAt;
	}

	public void setSavedAt(Timestamp savedAt) {
		this.savedAt = savedAt;
	}

	public List<ApiUsageRowDto> getBff() {
		return bff;
	}

	public void setBff(List<ApiUsageRowDto> bff) {
		this.bff = bff;
	}

	public List<ApiUsageRowDto> getBss() {
		return bss;
	}

	public void setBss(List<ApiUsageRowDto> bss) {
		this.bss = bss;
	}

	public List<ApiUsageRowDto> getExternal() {
		return external;
	}

	public void setExternal(List<ApiUsageRowDto> external) {
		this.external = external;
	}

	public List<ApiUsageRowDto> getJobs() {
		return jobs;
	}

	public void setJobs(List<ApiUsageRowDto> jobs) {
		this.jobs = jobs;
	}
}
