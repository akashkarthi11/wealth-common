package com.wealth.common.model.dto;

import java.io.Serializable;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class ThreadLocalDto  implements Serializable {
	@Transient
private static final long serialVersionUID = 8113016390553781656L;

private String userCode;
private String countryCode2;
private Integer userId;
private Integer groupSmeCompId;
private Integer smeCompId;
private String userType;
private String ip;
private String loginPortal;
private String emailId;
private String channelType;
private String jwtToken;
private String permissionId;
private String scope;
private String schema;
private String menuId;
private String appId;
private String preferredLanguage;
private String localeCode;
private String smeUserSupportCountries;
}
