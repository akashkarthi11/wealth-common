package com.wealth.common.model.dto.menu;

import java.io.Serializable;
import java.util.List;

// One entry of the navigation the signed-in user may see (from the table wealth_menus), with its submenus.
public class NavMenuDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String key;
	private String label;
	private String route;
	private String group;
	private List<NavMenuDto> children;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public List<NavMenuDto> getChildren() {
		return children;
	}

	public void setChildren(List<NavMenuDto> children) {
		this.children = children;
	}
}
