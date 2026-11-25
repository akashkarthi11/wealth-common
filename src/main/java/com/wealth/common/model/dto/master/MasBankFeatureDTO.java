package com.wealth.common.model.dto.master;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class MasBankFeatureDTO  implements Serializable {

	@Transient
	private static final long serialVersionUID = -4714735795601219458L;
	
	private int bankFeatureId;
	private int bankId;
	private int subFeatureId;
	private String subFeatureName;
	private int featureId;
	private String featureName;
	private String routingTypeCode;
    private String routingTypeName;
	private int feeId;
	private String feeName;
	private int activityId;
	private String activityName;
	private char recordState;
	private char checkBox;
	private Timestamp crtdDt;
//	private String crtdIp;
	private long crtdBy;
	private Timestamp updtDt;
//	private String updtIp;
	private long updtBy;
	private int menuId;
    private int permissionId;
}
