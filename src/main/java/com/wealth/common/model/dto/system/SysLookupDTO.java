package com.wealth.common.model.dto.system;

import java.io.Serializable;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class SysLookupDTO implements Serializable  {
	@Transient
	private static final long serialVersionUID = 2313277974150822123L;
	
	private int gxLookupId;
    private String gxLookupType;
    private String gxLookupCode;
    private String gxLookupValue;
    private String gxLookupDesc;
    private int gxLookupSeq;
    private int menuId;
    private int permissionId;

}
