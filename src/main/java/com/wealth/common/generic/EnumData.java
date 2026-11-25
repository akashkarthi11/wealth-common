package com.wealth.common.generic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public final class EnumData {

    public static final String directBank="DB";
	public static final String centralBank="CB";

	// SMS provider routing keys — matched against SmsIntegrationDTO.provider
	public static final String smsProviderAws="AWS";

	private EnumData() {
        // prevent instantiation
    }

    // ===================== LOGIN & CUSTOMER =====================

    public static final String GXAD = "GXAD";
    public static final String GXBAD = "GXBAD";
    public static final String GXAPP = "GXAPP";

    public static final String EMAIL = "E";
    public static final String SMS = "S";
    public static final String BOTH = "B";

    public static final String PASSWORD_CHANGED_SUCCESSFULLY = "Password changed successfully";
    public static final String PASSWORD_CONFIRMED_SUCCESSFULLY = "Password confirmed successfully";
    public static final String OTP_SENT_SUCCESSFULLY_MSG = "OTP sent successfully";
    public static final String OTP_VERIFIED_SUCCESSFULLY = "OTP verified successfully";
    public static final String SECURITY_QUESTIONS_VERIFIED_SUCCESSFULLY =
            "Security questions verified successfully";
    public static final String PASSWORD_UPDATED_SUCCESSFULLY = "Password updated successfully";

    public static final String SECURITY_QUESTIONS_FETCHED_SUCCESSFULLY =
            "SECURITY QUESTIONS_FETCHED_SUCCESSFULLY";
    public static final String MENU_LIST_FETCHED_SUCCESSFULLY =
            "MENU LIST FETCHED_SUCCESSFULLY";
    public static final String OTP_SENT_SUCCESSFULLY = "OTP_SENT_SUCCESSFULLY";

    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_EXPIRED = "expired";
    public static final String STATUS_COMPLETED = "completed";
    public static final String STATUS_REJECTED = "rejected";

    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_USER = "user";

    public static final String FORGET_PASSWORD = "forgetPassword";
    public static final String FORGET_MPIN = "forgetMpin";
    public static final String DEFAULT_PASSWORD_MASK = "*********";
    public static final String SECURITY_QUESTION_KEY = "sec";

    public static final String LOGIN = "login";
    public static final String INVITE = "invite";
    public static final String SELF = "self";

    public static final String CENTRAL_BANK = "CB";
    public static final String DIRECT_BANK = "DB";

    public static final char STATUS_DELETE = 'D';
    public static final char STATUS_ACTIVE_FLAG = 'A';
    public static final char STATUS_INACTIVE_FLAG = 'I';

    public static final char IS_REMOVED_YES = 'Y';
    public static final char IS_REMOVED_NO = 'N';

    public static final char OTP_TYPE_EMAIL = 'E';

    public static final String LANGUAGE_ENGLISH = "EN";

    public static final String LOCK = "LOCK";
    public static final String UNLOCK = "UNLOCK";

    // ===================== ACCESS / LIMITS =====================

    public static final String USER_ACCESS_REQUEST = "USER_ACCESS_REQUEST";
    public static final String INVITE_USER = "INVITE_USER";

    public static final String PER_TRANSACTION = "Per Transaction";
    public static final String PER_MONTH = "Per Month";
    public static final String PER_QUARTER = "Per Quarter";
    public static final String PER_YEAR = "Per Year";
    public static final String PER_WEEK = "Per Week";

    // ===================== SME IDENTITY DOCUMENTS =====================

    public static final String EMIRATES_ID = "Emirates ID";
    public static final String AADHAAR = "Aadhaar";
    public static final String PAN = "PAN";
    public static final String GCC_NATIONAL_ID = "GCC National ID";
    public static final String PASSPORT = "Passport";
    public static final String UAE_PASSPORT = "UAE Passport";

    // ===================== ACCOUNT TYPES =====================

    public static final String ACCOUNT_TYPE_LOAN = "LOAN";
    public static final String ACCOUNT_TYPE_CARD = "CARD";
    public static final String ACCOUNT_TYPE_CASA = "CASA";
    public static final String ACCOUNT_TYPE_DEPOSIT = "DEPOSIT";

    public static final String SORT_DESC = "DESC";
    public static final String SORT_ASC = "ASC";

    // ===================== AUDIT =====================

    public static final String AUDIT_ACTION_CREATE = "CREATE";
    public static final String AUDIT_ACTION_DELETE = "DELETE";
    public static final String AUDIT_ACTION_UPDATE = "UPDATE";
    public static final String AUDIT_ACTION_ACTIVATION_STATUS = "SUSPEND/ACTIVE";

    // ===================== WORKFLOW STATUS =====================

    public static final String SAVE_AS_DRAFT = "2010";
    public static final String AWAITING_APPROVAL = "2015";
    public static final String APPROVED = "2020";
    public static final String SENT_FOR_REPAIR = "2025";
    public static final String REJECTED_BY_APPROVER = "2030";
    public static final String DELETED = "2040";
    
    //============================APPROVAL===================================

    public static final String Users = "USER";
    public static final String SME = "SME";
    public static final String Role = "ROLE";
    public static final String Charges = "CHARGE";
    public static final String Approved = "A";
    public static final String Rejected = "R";
    public static final int ActivityId = 3;
    
    // ===================== SECURITY =====================

    public static final String HTML_TAG_PATTERN = "<[^>]+>";

    public static final String AUTHORIZATION = "Authorization";
    public static final String MENU = "menu";
    public static final String PERMISSION = "permission";
    public static final String PORTAL = "Portal";
    public static final String APP_ID = "appId";
    public static final String SCOPE = "scope";
    public static final String USER_AGENT = "User-Agent";
    public static final String X_USER_CODE = "X-USER-CODE";
    public static final String TENANT_ID = "tenant_id";
    public static final String X_TENANT_ID = "X-TENANT-ID";
    public static final String X_USER_ID = "X-USER-ID";
    public static final String X_GROUP_SME_COMP_ID = "X_GROUP_SME_COMP_ID";
    public static final String X_CHANNEL_TYPE = "X_CHANNEL_TYPE";
    public static final String X_ROUTING_TYPE = "X_ROUTING_TYPE";
    public static final String X_COUNTRY_CODE2 = "X_COUNTRY_CODE2";
    // ===================== TOKEN / CLAIM =====================

    public static final String TOKEN_TYPE = "type";
	public static final String SESSION_VERSION_CLAIM = "sv";
    public static final String TOKEN_TYPE_LONG = "LONG";
    public static final String TOKEN_TYPE_SHORT = "SHORT";

    // ===================== SCOPE =====================

    public static final String SCOPE_JOB = "job";
    public static final String SCOPE_USER = "user";
    public static final String SCOPE_OPENAPI = "openapi";

    // ===================== CHANNEL =====================

    public static final String CHANNEL_MOBILE = "Mobile";
    public static final String CHANNEL_WEB = "Web/desktop";

    // ===================== DEFAULTS =====================

    public static final String DEFAULT_APP_ID =
            "7839f2d2-230a-41f3-a6ae-4fbb2c8b3e2a";
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String DEFAULT_SCOPE = "web";

    // ===================== IP HEADERS =====================

    protected static final List<String> IP_HEADER_CANDIDATES = Arrays.asList(
            "X-Forwarded-For",
            "X-Real-IP",
            "CF-Connecting-IP",
            "True-Client-IP",
            "Forwarded",
            "Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_CLIENT_IP",
            "HTTP_X_FORWARDED_FOR",
            "X-USER-ID"
    );

    // ===================== USER AGENT =====================

    public static final String UA_ANDROID = "android";
    public static final String UA_IPHONE = "iphone";
    public static final String UA_IPAD = "ipad";
    public static final String UA_IPOD = "ipod";
    public static final String UA_BLACKBERRY = "blackberry";
    public static final String UA_WINDOWS_PHONE = "windows phone";
    public static final String UA_OPERA_MINI = "opera mini";
    public static final String UA_MOBILE = "mobile";

    // ===================== REDIS / CRYPTO =====================

    public static final String REDIS_STATUS = "spring.redis.enabled";
    public static final String CIPHER_AES_GCM = "AES/GCM/NoPadding";
    public static final String SHA_512 = "SHA-512";

    // ===================== FX =====================

    public static final String FX_RATE_BID = "Bid";
    public static final String FX_RATE_OFFER = "Offer";

    public static final String FX_PATH_SAME = "SAME";
    public static final String FX_PATH_MIDDLE = "MIDDLE";
    public static final String FX_PATH_DIRECT_INVERSE = "DIRECT/INVERSE";

    public static final String FX_SEPARATOR_PAIR = "/";
    public static final String FX_SEPARATOR_RATE = ":";

    public static final int FX_RATE_SCALE = 6;
    public static final int FX_MIDDLE_DIVISOR = 2;

    // ===================== VALIDATION MESSAGES =====================

    public static final String INVALID_NUMBER = "Invalid number";
    public static final String INVALID_EMAIL = "Invalid email";
    public static final String INVALID_DOCUMENT = "Invalid Document";
    public static final String INVALID_AADHAAR = "Invalid Aadhaar";
    public static final String INVALID_PAN = "Invalid PAN";
    public static final String INVALID_PASSPORT = "Invalid Passport";
    public static final String INVALID_EMIRATES_ID = "Invalid Emirates ID";
    public static final String INVALID_GCC_ID = "Invalid GCC ID";
	public static final String X_App_ID = "X-App-ID";

    // ===================== UTILITY =====================

    public static String getConstantNameByValue(String value) {
        try {
            for (Field field : EnumData.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    Object fieldValue = field.get(null);
                    if (value != null && value.equals(fieldValue)) {
                        return field.getName().replace('_', ' ');
                    }
                }
            }
        } catch (IllegalAccessException ignored) {
            // intentionally ignored
        }
        return null;
    }

	public static List<String> getIpHeaderCandidates() {
		return IP_HEADER_CANDIDATES;
	}
}
