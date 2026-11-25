package com.wealth.common.model.entity.system;

import com.wealth.common.model.entity.GenericEntity;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class SysCountryEntity extends GenericEntity {
	@Transient
	private static final long serialVersionUID = -4855139610868280554L;
	private Integer globalCountryId;
	private String countryName;
	private String countryCode2;
	private String countryCode3;
	private String region;
	private String dialCode;
	private String ibanRequired;
	private String basicbanBegin;
	private String basicbanEnd;
	private Integer ibanLength;
	private String currencyCode;
	private String currencyName;
	private Integer denomination;
	private String debitPurposeFlag;
	private String benePurposeFlag;
	private String countryTimeZone;

	@Override
	public String tableName() {
		return "GXSYS_GLOBAL_COUNTRY";
	}

	@Override
	public String primaryKey() {
		return "globalCountryId";
	}

}
