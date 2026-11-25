package com.wealth.common.model.entity;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class GxsysApplicationConfig extends GenericEntity {

	@Transient
	private static final long serialVersionUID = 319719845586679184L;
    private String applicationName;
    private String schemaName;
    private String appDescription;
    private String version;
    private String routingTypeCode;
    private String benePurposecodeCountrycode2;
    private String twoFactorAuth;
    private String lastApprove;
    
	@Override
	public String tableName() {
		return "gxsys_tenant";
	}
	@Override
	public String primaryKey() {
		return "tenant_id";
	}

 
}
