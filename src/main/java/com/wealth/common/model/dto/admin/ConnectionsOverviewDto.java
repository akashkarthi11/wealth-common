package com.wealth.common.model.dto.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Every connection in the three parts: main (the API settings, one row per provider), common (the one key for everyone) and user (each user's own key). An admin gets every user's rows
// and the common keys; anyone else gets only their own user rows and no common keys. admin tells the screen which one it is.
public class ConnectionsOverviewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean admin;
	private List<ConnectionOverviewRowDto> main = new ArrayList<>();
	private List<ConnectionOverviewRowDto> common = new ArrayList<>();
	private List<ConnectionOverviewRowDto> user = new ArrayList<>();

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<ConnectionOverviewRowDto> getMain() {
		return main;
	}

	public void setMain(List<ConnectionOverviewRowDto> main) {
		this.main = main;
	}

	public List<ConnectionOverviewRowDto> getCommon() {
		return common;
	}

	public void setCommon(List<ConnectionOverviewRowDto> common) {
		this.common = common;
	}

	public List<ConnectionOverviewRowDto> getUser() {
		return user;
	}

	public void setUser(List<ConnectionOverviewRowDto> user) {
		this.user = user;
	}
}
