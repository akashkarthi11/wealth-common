package com.wealth.common.model.dto.customer;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.ToString;

@Data
public class CompanyUserDTO  implements Serializable {

	@Transient
	private static final long serialVersionUID = 4445236184754707241L;

	private String tenantId;
	
	private int wkfId;
	private int userId;
	private int groupSmeCompId;
	private String userCode;
	private String portalCode;
	private int portalId;
	private int smeCompId;
	private int bankId;
	private int compRoleId;
	private int compUserRoleId;
	private Timestamp dob;
	private String nationality;
	private String firstName;
	private String lastName;
	private String displayName;
	private String userDesignation;
	private String userLoginId;
	private String emailId;
	private String maskEmailId;
	private String mobileCode;
	private String mobileNo;
	private String maskMobileNo;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String countryCode2;
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@JsonIgnore
	@ToString.Exclude
	private String mpin;
	private Timestamp passwordExpDt;
	private String documentType;
	private String documentValue;
	private String maskDocumentValue;
	private String preferredLang;
//	@JsonIgnore
//	@ToString.Exclude
	private String userLoginToken;
	private Timestamp userLastLoginTime;
	private int attemptLoginMpin;
	private int attemptLoginPwd;
	private String userType;
	private String roleName;
	private String userRegisterType;
	private String crtdByName;
    private String recordStatusCode;
    private String recordStatusCodeDesc;
    private String remarks;
	private Timestamp crtdDt;
	private String crtdIp;
	private int crtdBy;
	private Timestamp updtDt;
	private String updtIp;
	private int updtBy;
	private String portalCompanyId;
	private String userDeviceId;
	private String deviceId;
	private String userName;
	private Timestamp mpinLastUpdtDt;
	@JsonIgnore
	@ToString.Exclude
	private String accessToken;
	@JsonIgnore
	@ToString.Exclude
	private String refreshToken;
	private Timestamp accessTokenExp;
	@JsonIgnore
	@ToString.Exclude
	private Timestamp refreshTokenExp;
	private String otp;
	private String secretKey;
	private String currencyCode;
	private String type;
	private String groupCompName;
	private String onboardDefaultDataType;
	private String userLockStatus;
	private String userDevicePuk;
	private String createNotes;
	private String rejectNotes;
    @Schema(description = "Email ID verified flag: Y/N", example = "Y")
    private char emailIdVerified;
    @Schema(description = "MPIN enable flag: Y/N", example = "Y")
    private char mpinEnableFlag;
    @Schema(description = "Face biometric enable flag: Y/N", example = "N")
    private char bioFaceEnableFlag;
    @Schema(description = "Fingerprint biometric enable flag: Y/N", example = "Y")
    private char bioFingerprintEnableFlag;
    @Schema(description = "User status: A (Active) / I (Inactive)", example = "A")
    private char recordState;
	private char isBankConnect;
	private char passwordEnableFlag;
	private char isConsentCheck;
	private char lfiHolder;
	private char userAdmin;
	private String userMpinLockStatus; 
	private char userFirstTimeLogin;
	private char biometricEnableFlag;
	private char isKycVerified;
	private char isAccountCheck;
	private String countryName;
	private String profileImageName;
	private String profileImagePath; 
	private String compLogoName;
	private int menuId;
    private int permissionId;
    private CompanyUserRoleDTO userRole;
	private List<CompanyUserCountryDTO> countryList;
	private List<CompanyUserBankDTO> userBankList;
	private List<CompanyUserBankFeatureDTO>  userFeatureDto;
	private Timestamp mpinExpDt;
	private String vcifId;
	private String groupId;
	private char isWhatsappNotify;
	private char isSelfAuth;	
	private char isUserVerified;	// If user EXIST in WKF_COMP_USER table - 'N' , for all other users 'Y'
	private char companyExistsFlag;	// Node for deciding to show SME onboarding screen or GrowX Company ID screen
	private String supportedCountries;
	private String whatsappNo;
	private String userRefId;
	private String fcmToken;
    private int authGroupId;
    private int sourceUserId;
    private String groupCode;
    private Timestamp inviteExpiryDt;
    private int inviteVerifyAttempts;
    private Timestamp inviteUnlockDt;
    private String compRequestCounts;
    private String gxClientid;
    private char isCfoAcknowledged;
    private char isCfoDiscHidden;


	
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId == null ? null : emailId.toLowerCase();
    }
	
    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId == null ? null : userLoginId.toLowerCase();
    }

}
