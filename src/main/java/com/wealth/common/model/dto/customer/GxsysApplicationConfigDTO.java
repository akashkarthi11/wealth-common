package com.wealth.common.model.dto.customer;

import java.sql.Timestamp;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class GxsysApplicationConfigDTO {

	@Transient
	private static final long serialVersionUID = 319719845586679184L;
	private String tenantId;
    private String applicationName;
    private String schemaName;
    private String appDescription;
    private String version;
    private String routingTypeCode;
    private String benePurposecodeCountrycode2;
    private String twoFactorAuth;
    private String lastApprove;
    private char recordState;
    private String crtdDt;
//    private String crtdIp;
    private int crtdBy;
    private String updtDt;
//    private String updtIp;
    private int updtBy;


 
}
