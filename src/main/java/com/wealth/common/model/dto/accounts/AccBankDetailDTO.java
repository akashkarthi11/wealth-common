package com.wealth.common.model.dto.accounts;

import java.io.Serializable;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class AccBankDetailDTO implements Serializable {
	@Transient
	private static final long serialVersionUID = -2136335161788864994L;
	
	private int bankId;
	private String accountCountryCode2;
	private String routingTypeCode;
	private int subFeatureId;
	private int accountId;
	private int smeCompId;
	private int menuId;
    private int permissionId;
}
