package com.wealth.common.generic;

import java.lang.reflect.Field;

public class BaseError {

	public static final String USER_NOT_FOUND = "601";
	public static final String PASSWORD_MISMATCH = "602";
	public static final String OTP_MISMATCH = "603";
	public static final String EXPIRED = "604";
	public static final String ANSWER_NOT_FOUND = "605";
	public static final String ANSWER_MISMATCH = "606";
	public static final String SECURITY_KEY_MISMATCH = "607";
	public static final String INVALID_OLD_PASSWORD = "608";
	public static final String PASSWORD_CANNOT_BE_EMPTY = "609";
	public static final String UNKNOWN_QUESTION = "610";
	public static final String INVALID_REQUEST = "611";
	public static final String INVALID_USER_TYPE = "612";
	public static final String OTP_NOT_FOUND = "613";
	public static final String OTP_EXPIRED_OR_INVALID = "614";
	public static final String PERMISSION_NOT_FOUND = "615";
	public static final String ASSEMBLER_ERROR = "616";
	public static final String INVALID_OR_EXPIRED_REFRESH_TOKEN = "617";
	public static final String FAILED_TO_EXTRACT_CLAIMS = "618";
	public static final String USER_CODE_NOT_FOUND_IN_REFRESH_TOKEN = "627";
	public static final String USER_NOT_FOUND_FOR_REFRESH_TOKEN = "628";
	public static final String EMAIL_CANNOT_BE_NULL_OR_EMPTY = "629";
	public static final String EMAIL_OR_OTP_CANNOT_BE_NULL_OR_EMPTY = "630";
	public static final String PERMISSION_IDS_BY_USER_CODE = "631";
	public static final String USER_DATA_NULL_OR_EMPTY = "632";
	public static final String USER_LOGIN_ID_OR_EMAIL_EMPTY = "633";
	public static final String PASSWORD_OR_MPIN_EMPTY = "634";
	public static final String OTP_EMPTY = "635";
	public static final String MPIN_EMPTY = "636";
	public static final String PASSWORD_EMPTY = "637";
	public static final String ONLY_CORPORATE_EMAILS_ALLOWED = "638";
	public static final String MPIN_MUST_BE_6_DIGITS = "639";
	public static final String INVALID_EMAIL_FORMAT = "640";
	public static final String OTP_MUST_BE_6_DIGITS = "641";
	public static final String NEW_MPIN_MUST_BE_DIFFERENT = "642";
	public static final String SQL_INJECTION_NOT_ALLOWED = "643";
	public static final String REQUIRED_FIELD_MISSING = "644";
	public static final String INVALID_SUB_FEATURE = "645";
	public static final String HTML_NOT_ALLOWED = "646";
	public static final String ERROR_WHILE_SAVING_PAYMENT_TYPE = "647";
	public static final String ERROR_WHILE_UPDATING_PAYMENT_TYPE = "648";
	public static final String FAILED_TO_GET_ALL_PAYMENT_TYPE = "649";
	public static final String FAILED_TO_GET_PAYMENT_TYPE_BY_ID = "650";
	public static final String ERROR_WHILE_SAVING_AUTHMATRIX = "651";
	public static final String ERROR_WHILE_UPDATING_AUTHMATRIX = "652";
	public static final String ERROR_WHILE_DELETING_AUTHMATRIX = "653";
	public static final String ERROR_WHILE_GET_AUTHMATRIX_BY_ID = "654";
	public static final String FAILED_TO_GET_PAYMENT_TYPE_ID = "655";
	public static final String INVALID_AMOUNT_RANGE = "656";
	public static final String FAILED_TO_GET_SUB_FEATURE_FOR_USER = "657";
	public static final String INVALID_AUTHMATRIX_LEVEL = "658";
	public static final String AUTHMATRIX_NOT_FOUND = "659";
	public static final String GENERATE_SQL_PK_ERROR = "660";
	public static final String CONSENT_NOT_ENABLED = "661";
	public static final String UPLOADED_FILE_MUST_HAVE_A_VALID_NAME = "662";
	public static final String MPIN_INVALID = "663";
	public static final String PASSWORD_ENABLE_FLAG_IS_NO = "664";
	public static final String PASSWORD_EXPIRED = "665";
	public static final String OTP_TIME_EXPIRED = "666";
	public static final String USER_CONSENT_HEALTH_CHECK = "667";
	public static final String USER_CONSENT_NOT_FOUND = "668";
	public static final String USER_CONSENT_STATUS_UPDATE_FAILED = "669";
	public static final String USER_CONSENT_ACCOUNT_STATUS_UPDATE_FAILED = "670";
	public static final String USER_CODE_NOT_FOUND_IN_TOKEN = "670";
	public static final String SAVE_FAILED = "671";
	public static final String COMPANY_NAME_NULL_OR_EMPTY = "672";
	public static final String OTP_STATUS_CODE_MISMATCH = "673";
	public static final String OTP_TYPE_MISMATCH = "674";
	public static final String WORKFLOW_DELETED_SUCCESSFULLY = "675";
	public static final String EMAILID_ALREADY_PRESENT = "676";
	public static final String USERID_ALREADY_PRESENT = "677";
	public static final String EMAILID_NOT_FOUND = "678";
	public static final String COMPANY_FEATURE_ACCOUNT_IS_NOT_FOUND = "679";
	public static final String CONSENT_NOT_HAVE_PERMISSION = "680";
	public static final String REVOKED_CONSENT = "681";

	// signature validation errors
	public static final String INVALID_SIGNATURE = "680";
	public static final String SIGNATURE_VALIDATION_FAILED = "681";
	public static final String LOGIN_SESSION_NOT_FOUND = "682";
	public static final String USER_DEVICE_NOT_REGISTERED = "683";
	public static final String LOGIN_PROCESS_ID_EMPTY = "684";
	public static final String SIGNATURE_EMPTY = "685";
	public static final String USER_DEVICE_ID_EMPTY = "686";
	public static final String USER_DEVICE_PUK_EMPTY = "687";
	public static final String DEVICE_ID_EMPTY = "688";
	public static final String INVALID_MPIN_ENABLE_FLAG = "689";
	public static final String DEVICE_ID_REQUIRED = "690";
	public static final String MPIN_STATUS_EMPTY = "691";
	public static final String INVALID_MPIN_STATUS_VALUE = "692";
	public static final String ADMIN_NOT_APPROVED = "693";
	public static final String USER_HAVE_MULTIPLE_CONSENT = "694";
	public static final String IDP_TOKEN_ERROR = "695";
	public static final String KAFKA_SEND_FAILURE = "696";

//	 SAVE_FAILED 
//	 UPDATE_FAILED 
//	 OTP_STATUS_CODE_MISMATCH 
//	 OTP_TYPE_MISMATCH 

	// A1 ----end 701 to 1000---

	// ------------------------------CUSTOMER----------------------------------------------------------------
	// // Error codes for A2 section, numeric values starting from 701
	// User validation-status errors (aligned with validateUserStatus / VALIDATE_USER query outcomes)
//	public static final String USER_IS_DELETED = "5005";
	
	public static final String USER_DESIGNATION_NOT_PRESENT = "701";
	public static final String USER_LOGIN_ID_NOT_PRESENT = "702";
	public static final String MOBILE_CODE_NOT_PRESENT = "703";
	public static final String MOBILE_NUMBER_NOT_PRESENT = "704";
	public static final String DOCUMENT_TYPE_NOT_PRESENT = "705";
	public static final String DOCUMENT_VALUE_NOT_PRESENT = "706";
	public static final String INVALID_ACTIVATION_STATUS = "707";
	public static final String USER_REGISTER_TYPE_NOT_PRESENT = "708";
	public static final String EMAIL_ID_VERIFIED_NOT_PRESENT = "709";
	public static final String MPIN_ENABLE_FLAG_NOT_PRESENT = "710";
	public static final String BIO_FACE_ENABLE_FLAG_NOT_PRESENT = "711";
	public static final String BIO_FINGERPRINT_ENABLE_FLAG_NOT_PRESENT = "712";
	public static final String STATUS_NOT_PRESENT = "713";
	public static final String STATUS_INVALID = "714";
	public static final String BANK_CONNECT_FLAG_NOT_PRESENT = "715";
	public static final String PASSWORD_ENABLE_FLAG_NOT_PRESENT = "716";
	public static final String CONSENT_CHECK_FLAG_NOT_PRESENT = "717";
	public static final String LFI_HOLDER_FLAG_NOT_PRESENT = "718";
	public static final String USER_ADMIN_FLAG_NOT_PRESENT = "719";
	public static final String USER_FIRST_TIME_LOGIN_NOT_PRESENT = "720";
	public static final String INVALID_ID = "721";
	public static final String FILTER_INPUT_NULL_OR_EMPTY = "722";
	public static final String FILTER_VALUE_NULL = "723";
	public static final String QUESTION_NUMBER_REQUIRED = "724";
	public static final String REQUEST_BODY_REQUIRED = "725";
	public static final String INVALID_ROLE_ID = "726";
	public static final String INVALID_EMAIL_INVALID = "727";
	public static final String EMAIL_NOT_PRESENT = "728";
	public static final String BANK_ID_REQUIRED = "729";
	public static final String BANK_NAME_NOT_PRESENT = "730";
	public static final String BANK_FEATURE_LIST_REQUIRED = "731";
	public static final String FEE_NAME_NOT_PRESENT = "732";
	public static final String SUBSCRIPTION_FLAG_NOT_PRESENT = "733";
	public static final String FEE_FREQUENCY = "734";
	public static final String EMIRATES_ID_ALREADY_EXISTS = "735";
	public static final String FEE_CURRENCY_CODE_REQUIRED = "736";
	public static final String FEE_DEOMINATION_REQUIRED = "737";
	public static final String CUSTOMER_AUDIT_SAVE_ERROR = "738";
	public static final String MOBILE_NOT_PRESENT = "739";
	public static final String FILE_UPLOAD_FAILED = "740";
	public static final String LOGO_LIST_FETCH_FAILED = "741";
	public static final String INVALID_REJECT_REASON = "742";
	public static final String ACCOUNT_COUNTRY_CODE2_NULL_OR_EMPTY = "743";
	public static final String TRANS_LIMIT_INVALID = "744";
	public static final String COUNTRY_CODE2_NULL_OR_EMPTY = "745";
	public static final String USER_SETTINGS_NOT_FOUND = "746";
	public static final String COMPANY_COUNTRY_IS_NULL = "747";
	public static final String INVALID_COMPANY_COUNTRY_ID = "748";
	public static final String SECRET_KEY_NULL_OR_EMPTY = "749";
	public static final String INVALID_LOCK_STATUS = "750";
	public static final String SME_COMPANY_LIST_IS_EMPTY = "751";
	public static final String USER_COUNTRY_IS_NULL = "752";
	public static final String GROUP_CODE_NULL_OR_EMPTY = "753";
	public static final String EMAIL_ALREADY_EXISTS = "754";
	public static final String INVALID_WKF_ID = "755";
	public static final String ROLE_NAME_ALREADY_EXISTS = "756";
	public static final String ROLE_DETAILS_REQUIRED = "757";
	public static final String USER_WHATSAPP_NUMBER_NOT_PRESENT = "758";
	public static final String MAS_BANK_ONBOARDING_ERROR = "759";
	public static final String INVALID_TENANT_ID = "760";
	public static final String INVITE_USER_DELETE_ERROR = "761";
	public static final String MOBILE_NUMBER_ALREADY_EXISTS = "762";
	public static final String ADMIN_USER_DATA_NULL_OR_EMPTY = "763";
	public static final String ACTION_TYPE_REQUIRED = "764";
	public static final String LAST_USER_IN_AUTH_GROUP = "765";
	public static final String BANK_NAME_ALREADY_PRESENT = "767";
	public static final String USER_BANK_LIST_NULL_OR_EMPTY = "768";
	public static final String INVALID_USER_BANK_SELECTION = "769";
	public static final String COMPANY_ALREADY_EXIST = "770";

	public static final String USER_WHATSAPP_NOTIFY_NOT_PRESENT = "771";
	public static final String SME_COUNTRY_ID_NULL_IN_COUNTRY = "772";
	public static final String GROUP_SME_COMP_ID_NULL_IN_COUNTRY = "773";
	public static final String COUNTRY_CODE2_IN_COUNTRY = "774";
	public static final String USER_BANK_LIST_EMPTY = "775";
	public static final String SME_COUNTRY_ID_NULL_IN_BANK = "776";
	public static final String BANK_ID_NULL_IN_BANK = "777";
	public static final String SME_COUNTRY_ID_IN_BANK = "778";
	public static final String USER_FEATURE_LIST_EMPTY = "779";
	public static final String DUPLICATE_GROUP_CODE_FOUND = "780";
	public static final String ACCOUNT_COUNTRY_CODE2_NULL_FOR_ACCOUNTS = "781";
	public static final String TRANSACTION_APPROVAL_LIMIT_NULL_FOR_ACCOUNTS = "782";
	public static final String DAILY_TRANSACTION_LIMIT_NULL_FOR_ACCOUNTS = "783";
	public static final String SHOW_ACCOUNT_BALANCE_NULL_FOR_ACCOUNTS = "784";
	public static final String SHOW_STATEMENTS_NULL_FOR_ACCOUNTS = "785";
	public static final String ACCOUNT_ID_NULL_FOR_ACCOUNTS = "786";
	public static final String ACCOUNT_NUMBER_NULL_FOR_ACCOUNTS = "787";
	public static final String ACCOUNT_TYPE_NULL_FOR_ACCOUNTS = "789";
	public static final String ACCESS_START_DATE_FOR_ACCOUNTS = "790";
	public static final String ACCESS_END_DATE_NULL_FOR_ACCOUNTS = "791";
	public static final String BANK_ID_NULL_FOR_ACCOUNTS = "792";
	public static final String COMP_BANK_ID_NULL_FOR_ACCOUNTS = "793";
	public static final String COUNTRY_LIST_IDS_NULL = "794";
	public static final String ROLE_ALREADY_EXIST = "795";
	public static final String INVALID_AUTHZ_TYPE = "796";
	public static final String VCID_ID_ALREADY_EXIST = "797";
	public static final String GROUP_ID_INVALID = "798";
	public static final String INVALID_ROUTING_TYPE = "799";
	public static final String GROUP_SME_NOT_PRESENT = "800";

	public static final String COMPANY_DATA_NULL_OR_EMPTY = "801";
	public static final String COMPANY_BANK_DATA_NULL_OR_EMPTY = "802";
	public static final String FEATURE_DATA_NULL_OR_EMPTY = "803";
	public static final String BANK_DATA_NULL_OR_EMPTY = "804";
	public static final String BANK_FEATURE_DATA_NULL_OR_EMPTY = "805";
	public static final String FAILED_TO_CREATE_FEATURE_ACCOUNT_NULL_OR_EMPTY = "806";
	public static final String INVALID_FILE_FORMAT = "807";
	public static final String FILE_READ_ERROR = "808";
	public static final String FAILED_TO_UPDATE_FEATURE_ACCOUNT_NULL_OR_EMPTY = "809";
	public static final String FILE_TOO_LARGE = "810";
	public static final String INVALID_EXTENSION = "811";
	public static final String INVALID_MIME_TYPE = "812";
	public static final String COMPANY_ACCOUNT_NULL_OR_EMPTY = "813";
	public static final String COMPANY_ACCOUNT_SME_COMP_ID_ERROR = "814";
	public static final String COMPANY_ACCOUNT_COMPANY_ID_ERROR = "815";
	public static final String COMPANY_ACCOUNT_COMP_BANK_ID_ERROR = "816";
	public static final String COMPANY_ACCOUNT_NAME_ERROR = "817";
	public static final String USER_IS_DELETED = "818";
	public static final String COMPANY_ACCOUNT_TYPE_ERROR = "819";
	public static final String COMPANY_ACCOUNT_CURRENCY_CODE_ERROR = "820";
	public static final String COMPANY_ACCOUNT_BANK_NAME_ERROR = "821";
	public static final String COMPANY_ACCOUNT_STATUS_ERROR = "822";
	public static final String COMPANY_ACCOUNT_ID_ERROR = "823";
	public static final String VCIF_ID_NULL = "824";
	public static final String VIRUS_SCAN_FAILED = "825";
	public static final String AUTH_GROUP_MAPPED_TO_AUTHMATRIX = "826";
	public static final String AUTH_GROUP_ID_REQUIRED = "827";
	public static final String AUTH_GROUP_NOT_FOUND = "828";
	public static final String SME_BANK_SUSPEND_OR_DELETE_ACC_ERROR = "829";
	public static final String AUTH_GROUP_MAPPED_TO_USERS = "830";
	public static final String COMPANY_LANDLINE_NULL_OR_EMPTY = "831";
	public static final String AUTH_GROUP_NAME_ALREADY_EXISTS = "832";
	public static final String TRADE_LICENSE_NULL_OR_EMPTY = "833";
	public static final String TRADE_LICENSE_INVALID_FORMAT = "834";
	public static final String TRADE_LICENSE_INVALID_LENGTH = "835";
	public static final String COMPANY_ACC_FIND_BY_ACC_NO_ERROR = "836";
	public static final String COMPANY_ACC_FIND_BY_SME_COMP_ID_ERROR = "837";
	public static final String COMPANY_PO_NULL_OR_EMPTY = "838";
	public static final String FAILED_TO_FETCH_ACC_DETAILS_BY_ACC_NO_ERROR = "839";
	public static final String COMPANY_PO_INVALID_FORMAT = "840";
	public static final String COMPANY_PO_INVALID_LENGTH = "841";
	public static final String COMPANY_ACC_UPDATE_COMP_ACC_ERROR = "842";
	public static final String COMPANY_ACC_FIND_COMP_ACC_BY_ID_ERROR = "843";
	public static final String FILE_NOT_FOUND = "844";
	public static final String CBS_ACCOUNT_ID_IS_NULL = "845";
	public static final String USER_VALIDATION_FAILED = "846";
	public static final String LAST_AUTHMATRIX_THRESHOLD_DELETE_NOT_ALLOWED = "847";
	public static final String COMPANY_FEATURE_ACC_GET_ALL_ERROR = "848";
	public static final String COMPANY_FEATURE_ACC_UPDATE_ERROR = "849";
	public static final String COMPANY_FEATURE_ACC_FIND_BY_ID_ERROR = "850";
	public static final String INVITE_CODE_LOCKED = "851";
	public static final String INVITE_CODE_EXPIRED = "852";
	public static final String PORTAL_ID_MISMATCH_FOR_PORTAL = "853";
	public static final String CONTACT_NAME_NOT_PRESENT = "854";
	public static final String COMPANY_FEATURE_FEE_FETCH_ERROR = "855";
	public static final String ADDRESS_LINE1_NOT_PRESENT = "856";
	public static final String TRADE_LICENSE_EXPIRY_DATE_NOT_PRESENT = "857";
	public static final String COMPANY_ROLE_PERMI_CREATE_ERROR = "858";
	public static final String COMPANY_ROLE_PERMI_FETCH_ERROR = "859";
	public static final String COMPANY_ROLE_PERMI_UPDATE_ERROR = "860";
	public static final String COMPANY_ROLE_PERMI_FIND_BY_ID_ERROR = "861";
	public static final String COMPANY_ROLE_PERMI_FIND_BY_COMP_ROLE_ID_ERROR = "862";
	public static final String COMPANY_ROLE_CREATE_ERROR = "863";
	public static final String COMPANY_ROLE_FETCH_ERROR = "864";
	public static final String COMPANY_ROLE_FIND_BY_ID_ERROR = "865";
	public static final String GROUP_NOT_APPLICABLE = "866";
	public static final String COMPANY_USER_FEATURE_CREATE_ERROR = "867";
	public static final String COMPANY_USER_FEATURE_FETCH_ERROR = "868";
	public static final String COMPANY_USER_FEATURE_UPDATE_ERROR = "869";
	public static final String COMPANY_USER_FEATURE_FIND_BY_ID_ERROR = "870";
	public static final String INVITE_ALREADY_VERIFIED = "871";
	public static final String INVALID_INVITE_CODE = "872";
	public static final String COMPANY_USER_ROLE_CREATE_ERROR = "873";
	public static final String COMPANY_USER_ROLE_FETCH_ERROR = "874";
	public static final String ROLE_PERMISSION_INVALID = "875";
	public static final String COMPANY_USER_ROLE_FIND_BY_ID_ERROR = "876";
	public static final String COMPANY_USER_ROLE_UPDATE_ERROR = "877";
	public static final String SME_ONBOARDING_ERROR = "878";
	public static final String SME_GET_ALL_COMPANY_ERROR = "879";
	public static final String SME_FIND_COMPANY_BY_ID_ERROR = "880";
	public static final String USER_REGISTRATION_AWAITING_APPROVAL = "881";
	public static final String USER_REGISTRATION_IN_DRAFT = "882";
	public static final String USER_STATUS_UNKNOWN = "883";
	public static final String FINANCIAL_COVENANT_LIMIT_EXCEEDED = "884";
	public static final String PARTNER_NAME_NULL_OR_EMPTY = "5012";
	public static final String PARTNER_NAME_ALREADY_EXIST = "5013";
	public static final String SME_GET_ALL_BANKS_ERROR = "885";
	public static final String SME_FIND_BANKS_BY_ID_ERROR = "886";
	public static final String SYS_BANK_GET_ALL_ERROR = "887";
	public static final String SYS_BANK_FIND_BY_ID_ERROR = "888";
	public static final String SYS_BANK_SEARCH_BY_OBJ_ERROR = "889";
	public static final String MAS_USER_GET_ALL_ERROR = "890";
	public static final String PAYMENT_RESPONSE_INVALID = "891";
	public static final String MAS_USER_GET_ALL_BY_TYPE_ERROR = "892";
	public static final String MAS_USER_NOT_FOUND_ERROR = "893";
	public static final String MAS_USER_FIND_BY_ID_ERROR = "894";
	public static final String MAS_USER_CREATE_ADMIN_ERROR = "895";
	public static final String MAS_USER_INVITE_ONBOARD_ERROR = "896";
	public static final String MAS_USER_INVITE_ONBOARD_VERIFY_ERROR = "897";
	public static final String MAS_USER_EMAIL_OR_OTP_EMPTY_ERROR = "898";
	public static final String MAS_USER_OTP_NOT_FOUND_ERROR = "899";
	public static final String USER_IS_SUSPENDED = "900";
	public static final String USER_REGISTRATION_REJECTED = "901";
	public static final String PAGINATION_ID_NULL_OR_EMPTY = "902";
	public static final String INVALID_AUTHMATRIX_ID = "903";
	public static final String INVALID_LOGIN_TOKEN = "904";
	public static final String USER_SELF_ONBOARD_LIST_ERROR = "905";
	public static final String INVALID_FEATURE_SELECTION = "906";
	public static final String FEE_ID_NOT_PRESENT = "907";
	public static final String FEE_ID_INVALID = "908";
	public static final String FEE_AMOUNT_NOT_PRESENT = "909";
	public static final String INVALID_QUESTION_ID = "910";
	public static final String MAS_USER_ROLE_CREATE_ERROR = "911";
	public static final String MAS_USER_ROLE_GET_ALL_ERROR = "912";
	public static final String MAS_USER_ROLE_FIND_BY_ID_ERROR = "913";
	public static final String MAS_USER_ROLE_UPDATE_ERROR = "914";
	public static final String MAS_ROLE_GET_ALL_ERROR = "915";
	public static final String MAS_ROLE_GET_BY_ID_ERROR = "916";
	public static final String MAS_ROLE_PERMI_CREATE_ERROR = "917";
	public static final String MAS_ROLE_PERMI_GET_ALL_ERROR = "918";
	public static final String MAS_ROLE_PERMI_FIND_BY_ID_ERROR = "919";
	public static final String MAS_ROLE_PERMI_UPDATE_ERROR = "920";
	public static final String MAS_FEE_GET_ALL_FAILED = "921";
	public static final String GET_ALL_FEE_ERROR = "922";
	public static final String GET_FEE_BY_ID_ERROR = "923";
	public static final String CREATE_FEE_ERROR = "924";
	public static final String UPDATE_FEE_BY_ID_ERROR = "925";
	public static final String DELETE_FEE_BY_ID_ERROR = "926";
	public static final String ERROR_WHILE_FETCHING_ALL_FEE_FEATURES = "927";
	public static final String ERROR_WHILE_FETCHING_FEE_FEATURE_BY_ID = "928";
	public static final String PASSPORT_ID_NOT_PRESENT = "929";
	public static final String EMIRATES_ID_NOT_PRESENT = "930";
	public static final String ERROR_WHILE_CREATING_FEE_FEATURE = "931";
	public static final String NO_DASHBOARD_DATA_FOUND = "932";
	public static final String DOCUMENT_ALREADY_EXISTS = "933";
	public static final String FINANCIAL_DENOMINATION_REQUIRED = "934";
	public static final String ROLE_NAME_REQUIRED = "935";
	public static final String INVALID_COMP_ROLE_ID = "936";
	public static final String MENU_NAME_REQUIRED = "937";
	public static final String INVALID_MENU_ID = "938";
	public static final String PERMISSION_NAME_REQUIRED = "939";
	public static final String MAS_USER_OTP_MISMATCH_ERROR = "940";
	public static final String MAS_USER_INVALID_REQUEST_ERROR = "941";
	public static final String FINANCIAL_PROFILE_REQUIRED = "942";
	public static final String FINANCIAL_PARTNER_REQUIRED = "943";
	public static final String MAS_USER_UPDATE_NOT_FOUND_ERROR = "944";
	public static final String MAS_USER_UPDATE_ERROR = "945";
	public static final String MAS_USER_FETCH_CONVERT_NOT_FOUND_ERROR = "946";
	public static final String MAS_USER_FETCH_CONVERT_ERROR = "947";
	public static final String MAS_USER_GET_BY_ROLE_ID_ERROR = "948";
	public static final String MAS_USER_GET_COMP_USERS_BY_ROLE_ID_ERROR = "949";
	public static final String PENDING_TRANSACTION_PRESENT_IN_AUTH_RANGE = "950";
	public static final String MAS_USER_GET_COMP_USERS_ERROR = "951";
	public static final String COMP_USERS_GET_FAILED = "952";
	public static final String INVALID_PERMISSION_ID = "953";
	public static final String MONEY_CONVERSION_FAILED = "954";
	public static final String DOCUMENT_TYPE_MISMATCH = "955";
	public static final String EMIRATES_ID_EMPTY = "956";
	public static final String EMIRATES_ID_INVALID_LENGTH = "957";
	public static final String EMIRATES_ID_INVALID_FORMAT = "958";
	public static final String CORRUPTED_REQUEST_THROTTLE_DATA = "959";
	public static final String INVALID_STATUS_PROVIDED = "960";
	public static final String ERROR_UPDATING_COMPANY_INFO = "961";
	public static final String COMPANY_ID_INVALID = "962";
	public static final String MAS_FEE_SEARCH_BY_ERROR = "963";
	public static final String FEE_NOT_FOUND_ERROR = "964";
	public static final String CBS_PERMISSION_GET_ERROR = "965";
	public static final String USER_CONSENT_ACC_PERMISSION_ERROR = "966";
	public static final String COMPANY_SECURITY_QUESTION_GET_ALL_ERROR = "967";
	public static final String COMPANY_SECURITY_QUESTION_UPDATE_ERROR = "968";
	public static final String MAX_COMPANY_REQUEST_LIMIT_REACHED = "969";
	public static final String MAX_REQUEST_LIMIT_REACHED_FOR_COMPANY = "970";
	public static final String ROLE_NOT_FOUND = "971";
	public static final String COMP_ACCOUNT_USER_GET_FAILED = "972";
	public static final String BIOMETRIC_AUTHENTICATION_FAILED = "973";
	public static final String INVALID_WORK_FLOW_ID = "974";
	public static final String COMPANY_USER_INVITE_UPDATE_ERROR = "975";
	public static final String ENTITY_TO_DTO_CONVERTION_FAILED = "976";
//	public static final String SME_UPDATE_ERROR = "977";
	public static final String MAPPED_USER_LAYOUT_WIDGETS_IS_FAILED = "977";

	public static final String INVALID_ONBOARD_DEFAULT_TYPE = "978";
	public static final String WKF_ID_REQUIRED = "979";
	public static final String INVALID_SELF_ONBOARD_DATA = "980";
	public static final String FEE_NAME_IS_EMPTY = "981";
	public static final String FEE_NAME_ALREADY_PRESENT = "982";
	public static final String FEE_DATA_EMPTY = "983";
	public static final String FEE_NAME_EMPTY = "984";
	public static final String COMPANY_ID_NOT_PRESENT = "985";
	public static final String USER_SELF_ONBOARD_VERIFY_MAIL_MISSING = "986";
	public static final String INVALID_STRIPE_SECRET_KEY = "987";
	public static final String INVALID_STRIPE_PUBLISHABLE_KEY = "988";
	public static final String INVALID_STRIPE_WEBHOOK_SECRET = "989";
	public static final String ERROR_DELETING_WORKFLOW_DATA = "990";
	public static final String WORKFLOW_ACCOUNTS_VIEW_ERROR = "991";
	public static final String INVITE_CUSTOMER_USER_FETCH_ERROR = "992";
	public static final String WORKFLOW_ACCOUNTS_NOT_FOUND = "993";
	public static final String ADDRESS_NOT_PRESENT = "994";
	public static final String INVALID_COMPANY_ID = "995";
	public static final String PORTAL_TYPE_NOT_PRESENT = "996";
	public static final String FIRST_NAME_NOT_PRESENT = "997";
	public static final String LAST_NAME_NOT_PRESENT = "998";
	public static final String DISPLAY_NAME_NOT_PRESENT = "999";
	public static final String ANSWER_REQUIRED = "1000";

	// A2 ----end 701 to 1000---

	// ------------------------------CUSTOMER----------------------------------------------------------------

	// -------------------------------------PAYMENTS---------------------------------------------------------------

	// A3 ----Start 1001 to 1200----

	// Purpose Codes
	public static final String PurposeCodesNotFound = "1001";

	// Beneficiary Errors
	public static final String BeneficiariesNotFound = "1002";
	public static final String InvalidBeneficiaryId = "1003";

	// Payment Types & Lookups
	public static final String PaymentTypesFetchError = "1004";
	public static final String LookupDataNotFound = "1005";

	// Authorization Matrix
	public static final String AuthMatrixNotFound = "1006";

	// Workflow
	public static final String WorkflowNotFound = "1007";
	public static final String WorkflowUpdateFailed = "1008";
	public static final String UnsupportedActionType = "1009";

	// Payment Indicator
	public static final String InvalidPaymentIndicator = "1010";

	// Payment Transfer
	public static final String PaymentTransactionNotFound = "1011";
	public static final String DuplicateCorebankPush = "1012";

	// General Mapping/Conversion
	public static final String ErrorConvertingToDTO = "1013";
	public static final String MappingFailed = "1014";

	// ===== PayTransferValidator =====

	// Null / Missing Objects
	public static final String ObjectIsNull = "1015";

	// Transfer Types
	public static final String TransferTypeIsNull = "1016";
	public static final String TransferTypeInvalid = "1017";

	// Account & Amount Validation
	public static final String BeneficiaryAccountIsNull = "1018";
	public static final String DebitAmountInvalid = "1019";
	public static final String CurrencyCodeIsNull = "1020";
	public static final String CountryCodeIsNull = "1021";
	public static final String PaymentDateIsNull = "1022";
	public static final String TransactionStatusIsNull = "1023";
	public static final String CreditAmountIsNull = "1024";

	// Payment Details
	public static final String PaymentDetailsIsNull = "1025";
	public static final String InternalRemarksIsNull = "1026";
	public static final String ScheduleTimeIsNull = "1027";
	public static final String RecurringIdIsNull = "1028";
	public static final String PurposeCodeIsNull = "1029";
	public static final String PaymentReferenceIsNull = "1030";
	public static final String ChargeAmountInvalid = "1031";
	public static final String ChargeBearerTypeIsNull = "1032";
	public static final String BeneficiaryEmailIsNull = "1033";
	public static final String BeneficiaryEmailInvalid = "1034";
	public static final String MobileNoIsNull = "1035";
	public static final String MobileNoInvalid = "1036";
	public static final String TransferNoteIsNull = "1037";

	// Recurring Validation
	public static final String RecurringDetailsInvalid = "1038";

	public static final String PageNoIsNull = "1039";
	public static final String PageSortByIsNull = "1040";

	// Business validation
	public static final String ProductAndAccountNotEntitled = "1041";
	public static final String HolidayCutoffExceeded = "1042";
	public static final String CurrencyCutoffExceeded = "1043";
	public static final String AccountRetrievalError = "1044";
	public static final String AccountsNotFound = "1045";
	public static final String QueryFailed = "1046";
	public static final String AccountBalanceRetrievalError = "1047";

	public static final String InvalidAmount = "1048";
	public static final String AmountExceedsLimit = "1049";

	public static final String LimitCheckfailed = "1050";
	public static final String APPROVAL_LIMIT_EXCEEDED = "1052";
	public static final String DAILY_LIMIT_NOT_FOUND = "1053";
	public static final String APPROVAL_LIMIT_NOT_FOUND = "1054";
	public static final String NO_DATA_FOUND = "1055";
	public static final String PROCEDURE_EXCEPTION = "1056";
	public static final String UNKNOWN_ERROR = "1057";

	public static final String ERROR_AUTHZ_INSERT = "1058";
	public static final String GENERIC_ERROR = "1059";
	public static final String APPROVER_COUNT_NOT_FOUND = "1060";
	public static final String BANK_ROUTING_ERROR = "1061";
	public static final String BanksNotFound = "1062";
	public static final String InvalidFxQuoteRequest = "1063";
	public static final String FxQuoteCreationError = "1064";
	public static final String FxQuoteAcceptError = "1065";
	public static final String InvalidPaymentReference = "1066";
	public static final String ParResponseFailed = "1067";
	public static final String BankIdInvalid = "1068";
	public static final String DebitAccountIsNull = "1069";
	public static final String LIMIT_SYSTEM_ERROR = "1070";
	public static final String BankIdIsNull = "1071";
	public static final String DEBIT_AND_CREDIT_ACCOUNTS_ARE_SAME = "1072";
	public static final String COMPANY_ACC_APPROVE_ERROR = "1073";
	public static final String COMPANY_ACC_DELETE_COMP_ACC_ERROR = "1074";

	public static final String SYSTEM_ERROR = "1100";
	public static final String UNSUPPORTED_TRANSACTION_TYPE = "1075";
	public static final String IPID_VALIDATION_FAILED = "1076";
	public static final String PAYMENT_ALREADY_INITIATED = "1077";

	// A3 ----End 1001 to 1200----

	// ----------------------------------------PAYMENTS-----------------------------------------------------

	// -----------------------------------This is
	// Beneficiary------------------------------------------------------
	// A2 ----Start 1201 to 1400----

	public static final String USER_NOT_AUTHENTICATED_OR_AUTHORIZED = "1201";
	public static final String USER_PROFILE_OR_ROLE_MISSING = "1202";
	public static final String PAYMENT_TYPE_NOT_FOUND = "1203";
	public static final String AUTHORIZATION_MATRIX_NOT_FOUND = "1204";
	public static final String BENEFICIARY_NOT_FOUND = "1205";
	public static final String ERROR_FETCHING_BENEFICIARIES = "1206";
	public static final String INVALID_BENEFICIARY_ID = "1207";
	public static final String ALREADY_REMOVED = "1208";
	public static final String NOT_FOUND_WITH_USER_ID = "1209";
	public static final String MAPPING_FAILED_FOR_AUTH_HISTORY = "1210";
	public static final String ERROR_WHILE_RETRIEVING = "1211";
	public static final String USER_PERMISSION_MISSING = "1212";
	public static final String STATUS_IS_ALREADY_PRESENT_FOR_BENEFICIARY = "1213";
	public static final String BENE_IS_INACTIVE = "1214";
	public static final String UNKNOWN_STATUS_FOR_BENEFICIARY = "1215";
	public static final String STATUS_IS_ALREADY_REJECT_FOR_BENEFICIARY = "1216";
	public static final String IFSC_OR_SWIFT_CODE_UNSUPPORTED_COUNTRY_CODE = "1217";
	public static final String OBJECT_IS_NULL = "1218";
	public static final String BENEFICIARY_NAME_IS_NULL = "1219";
	public static final String BENEFICIARY_EMAIL_IS_NULL = "1220";
	public static final String IFSC_OR_SWIFT_CODE_IS_NULL = "1221";
	public static final String BENEFICIARY_NICK_NAME_IS_NULL = "1222";
	public static final String BENEFICIARY_BANK_NAME_IS_NULL = "1223";
	public static final String BENEFICIARY_BANK_CLEARING_CODE_IS_NULL = "1224";

	// Beneficiary Summary (pagination)
	public static final String PAGE_NO_IS_NULL = "1225";
	public static final String PAGE_SIZE_IS_NULL = "1226";
	public static final String PAGE_SORT_BY_IS_NULL = "1227";
	public static final String BENEFICIARY_ID_IS_NULL = "1228";
	public static final String ERROR_FIELD_CONTAINS_SPECIAL_CHARACTERS = "1229";
	public static final String BENEFICIARY_EMAIL_INVALID = "1230";
	public static final String BENEFICIARY_ALREADY_PRESENT = "1231";

	// IBAN & Feature
	public static final String IBAN_NO_IS_EMPTY = "1232";
	public static final String IBAN_NO_IS_TOO_SHORT = "1233";

	public static final String SMECOMPID_AND_REQUEST_GIVEN_SMECOMPID_MISMATCH = "1234";
	public static final String ASSEMBLER_FAILED = "1235";
	public static final String FEATURE_NOT_ALLOWED_THIS_USER = "1236";
	public static final String REMARKS_MISSING_ADD_REMARK = "1237";
	public static final String BENEFICIARY_ACCOUNT_IS_NULL = "1238";
	public static final String BENEFICIARY_ALREADY_WAITING_FOR_APPROVAL = "1239";
	public static final String EDIT_NOT_ALLOWED_PENDING_TRANSACTIONS = "1240";
	public static final String SUCCESS = "1241";
	public static final String QUERY_FAILED = "1242";
	public static final String BENEFICIARY_STATUS_IS_REJECT_REMARK_IS_MANADATORY = "1243";
	public static final String STATUS_CODE_IS_NULL = "1244";
	public static final String FAVORITES_CANNOT_BE_ASSIGNED_TO_THIS_BENEFICIARY = "1245";
	public static final String INVALID_REQUEST_SUB_FEATURE_ID_IS_REQUIRED = "1246";

	// Extra
	public static final String BENEFICIARY_UPDATE_FAILED = "1247";
	public static final String SME_NOT_AUTHENTICATED_OR_AUTHORIZED = "1248";

	public static final String UPDATE_SUCCESS = "1249";
	public static final String PARTIALLY_UPDATE_SUCCESS = "1250";
	public static final String UPDATE_FAILED = "1251";
	public static final String IBAN_NO_INVALID = "1252";
	public static final String INVALID_BENEFICIARY = "1253";
	public static final String VALIDATION_FAILED = "1254";
	public static final String BENEFICIARY_EDIT_NOT_ALLOWED = "1255";
	public static final String ITS_NOT_APPROVED_BENEFICIARY = "1256";
	public static final String BENEFICIARY_NICK_NAME_IS_INVALID = "1257";
	public static final String BENEFICIARY_NICK_NAME_ALREADY_EXISTS = "1258";
	public static final String USER_NOT_ALLOWED_TO_APPROVE = "1259";
	public static final String USER_ROLE_IS_NOT_ASSIGN = "1260";
	public static final String NOT_GX_OR_ERP_USER = "1261";

	public static final String ConsentUsageSubtypeIsEmpty = "1262";
	public static final String ENTERED_AMOUNT_IS_HIGHER_THAN_BALANCE = "1263";
	public static final String INVALID_AMOUNT_OR_BALANCE = "1264";
	public static final String INVALID_AMOUNT_PRECISION = "1265";
	public static final String CREATE_FXQUOTE_ERROR = "1266";
	public static final String NONCE_CREATION_FAILED = "1267";
	public static final String NONCE_ID_IS_NULL = "1268";
	public static final String INVALID_NONCE = "1269";
	public static final String StatusCodeIsNull = "1270";
	public static final String BENEFICIARY_APPROVER_NAME_MISSING = "1271";
	public static final String BENEFICIARY_METROMAP_INSERT_FAILED = "1272";
	public static final String BENEFICIARY_CHANNEL_SYSTEM_NOT_ERP = "1273";
	public static final String SO_EXCEEDS_MAX_LIMIT_OF_53 = "1274";






	public static final String Success = "Success";

	// A2 ----End 1201 to 1247----

	// ------------------------------------ Beneficiary
	// ------------------------------------------------------

	// ----------------------------------------ACCOUNTSERVICE-----------------------------------------------------

	// A4 ----End 1001 to 1100---

	// A3 ----Start 1401 to 1435----

	public static final String ERROR_FETCHING_TOTAL_BALANCES = "1401";
	public static final String ERROR_FETCHING_TOTAL_ACCOUNTBALANCE = "1402";
	public static final String ERROR_FETCHING_TOTAL_ASSETSBALANCE = "1403";

	public static final String ACCOUNTDETAILS_NOT_FOUND_FORID = "1404";
	public static final String CURRENCIES_NOT_FOUND = "1405";
	public static final String ERROR_FETCHING_LIABILITIES_TOTAL_BALANCE = "1406";
	public static final String INVALID_ACCOUNT_ID = "1407";
	public static final String STATEMENTS_NOT_FOUND = "1408";
	public static final String FAILED_TO_SAVE_CUSTOM_STATEMENT_REQUEST = "1409";
	public static final String IMMEDIATE_ATTENTION_TRANSACTIONS_NOT_FOUND = "1410";
	public static final String RECENT_TRANSACTIONS_NOT_FOUND = "1411";
	public static final String MAPPING_FAILED_FOR_TRANSACTION_HISTORY = "1412";
	public static final String ACCOUNT_ACTIVITIES_NOT_FOUND = "1413";
	public static final String LOOKUP_TYPE_NOT_FOUND = "1414";
	public static final String ENTITY_TO_DTO_CONVERSION_FAILED = "1415";
	public static final String NO_LOOKUP_DATA_FOUND = "1416";
	public static final String INVALID_USER_ID = "1417";
	public static final String REQUEST_DTO_NULL = "1418";
	public static final String ACCOUNT_ID_INVALID = "1419";

	public static final String ACCOUNT_NO_INVALID = "1420";
	public static final String DEPOSIT_ACCOUNT_ACTIVITIES_NOT_FOUND = "1421";
	public static final String LOAN_ACCOUNT_ACTIVITIES_NOT_FOUND = "1422";

	public static final String ACCUSER_NOT_AUTHENTICATED_OR_AUTHORIZED = "1423";
	public static final String ACCOUNT_IBAN_NO_INVALID = "1424";
	public static final String PRODUCTS_NOT_MAPPED_TO_USER = "1425";
	public static final String STATEMENT_NOT_FOUND = "1426";
	public static final String CARDS_NOT_FOUND = "1427";
	public static final String TRANSACTION_ID_INVALID = "1428";
	public static final String ACCOUNT_NO_TOO_SHORT = "1429";
	public static final String DATE_IS_EMPTY = "1430";
	public static final String START_DATE_INVALID = "1431";
	public static final String DELIVERY_TYPE_IS_EMPTY = "1432";
	public static final String DELIVERY_TYPE_MUST_BE_MAIL_OR_WHATSAPP = "1433";

	public static final String DELIVERY_TYPE_MUST_BE_COURIER_OR_COLLECTION_CENTER = "1435";
	public static final String ONLY_ONE_CHEQUEBOOK_ALLOWED = "1436";
	public static final String INVALID_CHEQUEBOOK_LEAVES = "1437";
	public static final String COURIER_COLLECTOR_NAME_REQUIRED = "1438";
	public static final String COURIER_COUNTRY_CODE_REQUIRED = "1439";
	public static final String COURIER_COLLECTOR_NUMBER_REQUIRED = "1440";
	public static final String COURIER_COLLECTOR_ADDRESS_REQUIRED = "1441";
	public static final String COURIER_COLLECTOR_STATE_REQUIRED = "1442";
	public static final String COURIER_COLLECTOR_CITY_REQUIRED = "1443";
	public static final String COURIER_COLLECTOR_ZIP_REQUIRED = "1444";
	public static final String INVALID_BANK_BRANCH_ID = "1445";
	public static final String BANK_BRANCH_NAME_REQUIRED = "1446";
	public static final String BANK_BRANCH_ADDRESS_REQUIRED = "1447";
	public static final String BANK_BRANCH_COORDINATES_REQUIRED = "1448";
	public static final String COLLECTION_CENTER_COUNTRY_CODE_REQUIRED = "1449";
	public static final String COLLECTION_CENTER_PHONE_NUM_REQUIRED = "1450";

	public static final String DELIVERY_TYPE_REQUIRED = "1451";
	public static final String SELF_PHYSICAL_COPY_REQUIRED = "1452";
	public static final String SELF_EMAIL_REQUIRED = "1453";
	public static final String AUDITOR_FIELDS_MUST_BE_EMPTY_FOR_SELF = "1454";
	public static final String AUDITOR_PHYSICAL_COPY_REQUIRED = "1455";
	public static final String BOTH_PHYSICAL_COPIES_REQUIRED = "1456";
	public static final String SELF_EMAIL_REQUIRED_FOR_BOTH = "1457";
	public static final String UNSUPPORTED_DELIVERY_TYPE = "1458";

	public static final String AUDITOR_NAME_REQUIRED = "1459";
	public static final String AUDITOR_EMAIL_REQUIRED = "1460";
	public static final String AUDITOR_PHYSICAL_COPY_MISSING_FIELDS = "1461";
	public static final String AUDITOR_FIELDS_MUST_BE_EMPTY_WHEN_NO_PHYSICAL_COPY = "1462";
	public static final String CHEQUEBOOK_TYPE_MUST_BE_STANDARD = "1463";

	public static final String AUDITOR_COUNTRY_CODE_REQUIRED = "1464";
	public static final String AUDITOR_PHONE_REQUIRED = "1465";
	public static final String AUDITOR_ADDRESS_REQUIRED = "1466";
	public static final String AUDITOR_STATE_REQUIRED = "1467";
	public static final String AUDITOR_CITY_REQUIRED = "1468";
	public static final String AUDITOR_ZIP_CODE_REQUIRED = "1469";

	public static final String TOTAL_BALANCE_NOT_FOUND = "1470";
	public static final String TOTAL_BALANCE_CURRENCY_NOT_FOUND = "1471";

	public static final String TOTAL_ASSETS_BALANCE_NOT_FOUND = "1472";
	public static final String TOTAL_ASSETS_CURRENCY_NOT_FOUND = "1473";

	public static final String TOTAL_LIABILITIES_BALANCE_NOT_FOUND = "1474";
	public static final String TOTAL_LIABILITIES_CURRENCY_NOT_FOUND = "1475";
	public static final String CONVERT_CURRENCY_NOT_FOUND = "1476";
	public static final String CENTRAL_BANK_RESPONSE_NOT_FOUND = "1477";
	public static final String UNKNOWN_STATUS_FOR_ACCOUNT = "1478";

	public static final String NO_PENDING_REQUEST = "1479";
	public static final String PROGRESS_STATUS_NOT_UPDATED = "1480";
	public static final String COMPLETED_STATUS_NOT_UPDATED = "1481";
	public static final String RESET_PENDING_NOT_UPDATED = "1482";
	public static final String BANKS_NOT_FOUND = "1483";
	public static final String FAVOURITE_ACCOUNTS_NOT_FOUND = "1484";
	public static final String FAVOURITE_DEPOSIT_NOT_FOUND = "1485";
	public static final String FAVOURITE_LOAN_ACC_NOT_FOUND = "1486";
	public static final String FAVOURITE_CARD_NOT_FOUND = "1487";
	public static final String EMAIL_TEMPLATE_NOT_FOUND = "1488";
	public static final String FX_RATE_NOT_FOUND = "1489";
	public static final String SUB_FEATURE_NOT_MAPPED = "1490";
	public static final String PORTAL_TRANSACTIONS_NOT_FOUND = "1491";
	public static final String LOAN_ACCOUNTS_NOT_FOUND = "1492";
	public static final String CARD_DETAIL_NOT_FOUND = "1493";
	public static final String CASA_ACCOUNTS_NOT_FOUND = "1494";
	public static final String DEPOSIT_ACCOUNTS_NOT_FOUND = "1495";
	public static final String ACCOUNT_NOT_MAPPED_TO_PRODUCT = "1496";
	public static final String LOAN_DETAIL_NOT_FOUND = "1497";
	public static final String CARD_ACTIVITIES_NOT_FOUND = "1498";

	public static final String PAGINATION_DTO_NULL = "1500";
	public static final String PAGE_NUMBER_INVALID = "1501";
	public static final String PAGE_SIZE_INVALID = "1502";
	public static final String SORT_DIRECTION_INVALID = "1503";
	public static final String SEARCH_KEYWORD_TOO_LONG = "1504";
	public static final String CASA_BALANCE_FETCH_ERROR = "1505";
	public static final String DEPOSIT_BALANCE_FETCH_ERROR = "1506";
	public static final String LOAN_BALANCE_FETCH_ERROR = "1507";
	public static final String CARD_BALANCE_FETCH_ERROR = "1508";
	public static final String PAY_BY_BANK_NOT_SUPPORTED = "1509";
	public static final String FAILED_TO_SEND_EMAIL_NOTIFICATION = "1510";
	public static final String SMS_NOTIFICATION_FAILED = "1511";

	// ------------------------------ACCOUNTS
	// SERVICE----------------------------------------------------------------

	// -----------------------------------Integration--------------------------------------------------------------
//	public static final String technicalError="910";
	public static final String TimeoutError = "900";
	public static final String RemoteServiceError = "800";
	public static final String ERROR_IN_SUBMIT_PAYMENT = "901";
	public static final String ERROR_IN_PAYMENT_ENQUIRY = "902";

	// -----------------------------------Integration--------------------------------------------------------------

	public static final String CONSENT_ID_NOT_FOUND = "2000";
	public static final String CONSENT_DATA_NOT_FOUND = "2001";
	public static final String ERROR_VALIDATE_CONSENT = "2002";
	

	// -----------------------------------Integration--------------------------------------------------------------

	// -----------------------------------USER_CONSENT--------------------------------------------------------------

	public static final String USER_CONSENT_ID_IS_ZERO = "2200";
	public static final String SME_ID_IS_NULL = "2201";
	public static final String BANK_ID_IS_NULL = "2202";
	public static final String REVOKE_FAILED   = "2203";
	public static final String CONSENT_FAILED   = "2204";
	public static final String PAUSED_CONSENT_NOT_ALLOWED_TO_REVOKE   = "2205";
	public static final String SINGLE_INSTANT_PAYMENT_CONSENT    = "2206";
	public static final String SINGLE_FUTURE_DATED_PAYMENT_CONSENT   = "2207";
	public static final String ACCOUNT_ALREADY_EXISTS   = "2208";

	// -----------------------------------USER_CONSENT--------------------------------------------------------------

	// -----------------------------------This is
	// Payer------------------------------------------------------
	// ---Start 1600 till 1699
	public static final String INVALID_PAYER_ID = "1600";
	public static final String PAYER_NOT_FOUND = "1601";
	public static final String PAYER_NOT_AUTHENTICATED_OR_AUTHORIZED = "1602";
	public static final String PAYER_ASSEMBLER_FAILED = "1603";
	public static final String PAYER_QUERY_FAILED = "1604";
	public static final String PAYER_OBJECT_IS_NULL = "1605";
	public static final String PAYER_NAME_IS_NULL = "1606";
	public static final String PAYER_EMAIL_IS_NULL = "1607";
	public static final String PAYER_ADDRESS_LINE_1_IS_NULL = "1608";
	public static final String PAYER_BANK_NAME_IS_NULL = "1609";
	public static final String PAYER_REMARKS_MISSING_ADD_REMARK = "1610";
	public static final String PAYER_ALREADY_REMOVED = "1611";
	public static final String UNKNOWN_STATUS_FOR_PAYER = "1612";
	public static final String INVALID_SME_ID = "1613";
	public static final String FEATURE_NOT_ALLOWED_TO_USER = "1614";
	public static final String PAYER_ALREADY_WAITING_FOR_APPROVAL = "1615";
	public static final String STATUS_IS_ALREADY_REJECT_FOR_PAYER = "1616";
	public static final String STATUS_IS_ALREADY_PRESENT_FOR_PAYER = "1617";
	public static final String PAYER_AUTHZ_DATA_NOT_FOUND = "1618";
	public static final String USER_ALREADY_APPROVED_PAYER = "1619";
	public static final String INVALID_APPROVAL_STATUS = "1620";
	public static final String PAYER_UPDATE_SUCCESS = "1621";
	public static final String PAYER_UPDATE_FAILED = "1622";
	public static final String PAYER_UPDATE_PARTIAL_FAILED = "1623";
	public static String invoice_already_exits = "1624";
	public static String po_already_exits = "1625";
	public static final String PAYER_EMAIL_INVALID = "1626";
	public static final String PAYER_NOT_APPROVED_YET = "1627";
	public static final String PAYER_MOBILE_IS_NULL = "1628";

	public static final String PAYER_COUNTRY_CODE_IS_NULL = "1629";
	public static final String PAYER_MOBILE_CODE_IS_NULL = "1630";
	public static final String PAYER_EMAIL_ALREADY_EXISTS = "1631";
	public static final String PAYER_MOBILE_ALREADY_EXISTS = "1632";

	public static final String EMIRATES_ID_VERIFICATION_FAILED = "1634";
	public static final String NO_IMAGE_UPLOADED = "1635";
	public static final String ID_CARD_IMAGE_NOT_UPLOADED = "1636";
	public static final String SELFIE_IMAGE_NOT_UPLOADED = "1637";

	public static final String technicalError = "1638";
	public static final String TIME_OUT_ERROR = "1639";
	public static final String REMOTE_SERVICE_ERROR = "1640";

	// ---------------------------------------Payer----------------------------------------------------------

	public static String getConstantNameByValue(String value) {
		try {
			Field[] fields = BaseError.class.getDeclaredFields();
			for (Field field : fields) {
				if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
					Object fieldValue = field.get(null); // static fields => null instance
					if (fieldValue != null && fieldValue.equals(value)) {
						return field.getName();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // Not found
	}

	///////// -------------------Request -to - Pay--------------/////////////////
	/// -----------------------Starts from 1700---------------///////////////
	public static final String INVALID_RTP_REQUEST = "1700";
	public static final String INTERNAL_ERROR = "1701";
	public static final String INVALID_STATUS_UPDATE = "1702";
	public static final String INVALID_RTP_REQUEST_TO_FILTER = "1704";
	public static final String INVALID_PAYER = "1705";
	public static final String INVALID_DEPOSIT_ACCOUNT = "1706";
	public static final String INVALID_AMOUNT = "1707";
	public static final String INVALID_COLLECTION_DATE = "1708";
	public static final String INVALID_EXPIRY_DATE = "1709";
	public static final String SME_NOT_AUTHENTICATED = "1710";
	public static final String INVALID_PAYER_CONTACT = "1711";
	public static final String INVALID_MOBILE = "1712";
	public static final String INVALID_EMAIL = "1713";
	public static final String INVALID_PAYER_NAME = "1714";
	public static final String INVALID_PAGE_NO = "1716";
	public static final String INVALID_PAGE_SIZE = "1717";
	public static final String INVALID_SEARCH_TEXT = "1718";
	public static final String PAYER_LIST_EMPTY = "1719";
	public static final String RTP_LIST_EMPTY = "1720";
	public static final String RTP_METROMAP_INSERT_FAILED = "1731";
	public static final String NOT_FOUND_WITH_THE_USER_ID = "1722";
	public static final String ACCOUNTS_NOT_FOUND = "1723";
	public static final String RTP_FETCH_FAILED = "1724";
	public static final String PAYER_CONTACT_REQUIRED_FOR_ADHOC = "1725";
	public static final String PAYER_NAME_REQUIRED_FOR_ADHOC = "1726";
	public static final String RECORD_NOT_FOUND = "1727";
	public static final String QUERY_FAILES = "1728";
	public static final String DATA_NOT_FOUND_WITH_USER_ID = "1729";
	public static final String INVALID_WEBHOOK_TOKEN = "1730";
	public static final String MISSING_WEBHOOK_TOKEN = "1731";
	public static final String INVALID_RTP_STATUS_CODE = "1732";
	public static final String INVALID_RTP_DETAILS = "1733";
	public static final String RTP_REQUEST_VIA_IS_NULL = "1734";
	public static final String RTP_RECORD_STATUS_DUPLICATED_IS_NOT_ELIGIBLE = "1735";
	public static final String RTP_DUPLICATION_FAILED = "1736";
	public static final String RTP_UPDATE_FAILED = "1737";
	public static final String RTP_GX_CHANNEL_NO_NOT_FOUND = "1738";
	

	///////////////////////////////// IDP-Springboot//////////////////////////////////

	public static final String UNSUPPORTED_GRANT_TYPE = "1800";
	public static final String AUTH_CODE_REQUIRED = "1801";
	public static final String INVALID_OR_EXPIRED_TOKEN = "1802";
	public static final String CLIENT_NOT_AUTHENTICATED = "1803";
	public static final String SERVER_ERROR = "1804";
	public static final String NOT_FOUND_WITHTHE_USER_ID = "1805";
	public static final String INVALID_OR_EXPIRED_AUTH_CODE = "1806";
	public static final String USER_DATA_NULL_ORELSE_EMPTY = "1807";
	public static final String USER_DEVICE_PUK_IS_EMPTY = "1808";
	public static final String DEVICE_ID_IS_EMPTY = "1809";
	public static final String INVALID_MPIN_ENABLE__FLAG = "1810";
	public static final String USER_NOTFOUND = "1811";
	public static final String LOGIN_PROCESS_ID_IS_EMPTY = "1812";
	public static final String SIGNATURE_IS_EMPTY = "1813";
	public static final String USER_DEVICE_ID_IS_EMPTY = "1814";
	public static final String INVALID_LOGIN_PROCESS_ID = "1815";
	public static final String INVALID__SIGNATURE = "1816";
	public static final String FAILED_TO_GENERATE_AUTH_CODE = "1817";
	public static final String LOGIN_SESSION_IS_NOT_FOUND = "1818";
	public static final String ADMIN_NOTAPPROVED = "1819";
	public static final String USER_DEVICE_IS_NOT_REGISTERED = "1820";
	public static final String SIGNATURE_VALIDATION_WAS_FAILED = "1821";
	public static final String UNAUTHORIZED = "1822";
	public static final String MISSING_TOKEN = "1823";
	public static final String SESSION_EXPIRED_OR_INVALID = "1824";
	public static final String SECURITY_QUESTIONS_ARE_REQUIRED = "1825";
	public static final String SECURITY_QUESTION_VERIFICATION_FAILED = "1826";
	public static final String INVALID_SECURITY_QUESTION = "1827";
	public static final String INVALID_ANSWER = "1828";
	public static final String DUPLICATE_SECURITY_QUESTIONS_NOT_ALLOWED = "1829";
	public static final String PASSWORD_SHOULD_NOT_BE_EMPTY = "1830";
	public static final String INVALID_JTI_REQUEST = "1831";
	public static final String COMPANY_SECURITY_QUESTION_CREATED_ERROR = "1832";
	public static final String UNABLE_TO_FETCH_SECURITY_QUESTION = "1833";
	public static final String USER_ID_EMPTY = "1834";
	public static final String INVALID__USER_ID = "1835";
	public static final String SECURITY_QUESTIONS_NOT_FOUND = "1836";
	public static final String INTERNAL_SERVER_ERROR = "1837";
	public static final String INVALID_GRANT = "1838";
	public static final String CODE_VERIFIER_REQUIRED = "1839";
	public static final String INVALID_OAUTH_REQUEST = "1840";
	public static final String AUTHORIZATION_FAILED = "1841";
	public static final String KEY_FILE_NOT_FOUND = "1842";
	public static final String KEY_FILE_READ_ERROR = "1843";
	public static final String PUBLIC_KEY_LOAD_FAILED = "1844";
	public static final String PRIVATE_KEY_LOAD_FAILED = "1845";
	public static final String FAILED_TO_LOAD_JWKS = "1846";
	public static final String HASHING_FAILED = "1847";
	public static final String KEY_GENERATION_FAILED = "1848";
	public static final String ENCRYPTION_FAILED = "1849";
	public static final String INVALID_ENCRYPTED_DATA = "1850";
	public static final String DECRYPTION_FAILED = "1851";
	public static final String CONFIG_LOAD_FAILED = "1852";
	public static final String DB_UPDATE_FAILED = "1853";
	public static final String DATASOURCE_NOT_INITIALIZED = "1854";
	public static final String KEY_DERIVATION_FAILED = "1855";
	public static final String INVALID_LOGIN_PACKET = "1856";
	public static final String LOGIN_SESSION_SAVE_FAILED = "1857";
	public static final String KEY_LOAD_FAILED = "1858";
	public static final String INVALID_KEY_FORMAT = "1859";
	public static final String INVALID_PUBLIC_KEY = "1860";
	public static final String INVALID_PRIVATE_KEY = "1861";
	public static final String PUBLIC_KEY_NOT_FOUND = "1862";
	public static final String INVALID_TOKEN = "1863";
	public static final String TOKEN_HASH_FAILED = "1864";
	public static final String SESSION_CHILD_CREATION_FAILED = "1865";
	public static final String CLIENT_CREDENTIALS_TOKEN_GENERATION_FAILED = "1866";
	public static final String ACCESS_TOKEN_GENERATION_FAILED = "1867";
	public static final String ID_TOKEN_GENERATION_FAILED = "1868";
	public static final String FAILED_TO_INITIALIZE_RSA = "1869";
	public static final String PRIVATE_KEY_NOT_FOUND = "1870";
	public static final String FAILED_TO_SAVE_SESSION = "1871";
	public static final String PKCE_CHALLENGE_GENERATION_FAILED = "1872";
	public static final String UNSUPPORTED_CODE_CHALLENGE_METHOD = "1873";
	public static final String SELF_ONBOARD_RENDER_FAILED = "1874";
	public static final String METADATA_READ_FAILED = "1875";
	public static final String USER_UPDATE_FAILED = "1876";
	public static final String METADATA_UPDATE_FAILED = "1877";
	public static final String TOKEN_EXPIRY_MISSING = "1878";
	public static final String ACCESS_TOKEN_VALIDATION_FAILED = "1879";
	public static final String INVALID_TOKEN_AUDIENCE = "1880";
	public static final String TOKEN_SUBJECT_MISSING = "1881";
	public static final String INVALID_JWT_TOKEN = "1882";
	public static final String CRYPTO_FAILURE = "1883";
	public static final String ID_TOKEN_VALIDATION_FAILED = "1884";
	public static final String FAILED_TO_UPDATE_FIRST_TIME_LOGIN = "1885";
	public static final String LOGIN_SESSION_METADATA_PARSE_FAILED = "1886";
	public static final String LOGIN_SESSION_METADATA_SERIALIZATION_FAILED = "1887";
	public static final String OAUTH_METADATA_PARSE_FAILED = "1888";
	public static final String USER_ACCOUNT_LOCKED = "1889";
	public static final String INVALID_MPIN = "1890";
	public static final String USER_ID_IS_EMPTY = "1891";
	public static final String MPIN_IS_EMPTY = "1892";
	public static final String INVALID_CODE_VERIFIER = "1893";
	public static final String INVALID_CODE_CHALLENGE_METHOD = "1894";
    public static final String SERVICE_CLIENT_NOT_AUTHENTICATED = "1895";
    public static final String USER_SESSION_NOT_FOUND = "1896";
    public static final String USER_SESSION_CHILD_NOT_FOUND = "1897";
    public static final String DEVICE_ALREADY_REGISTERED_WITH_OTHER_USER = "1898";
    public static final String INVALID_USER_STATUS = "1899";
    public static final String FAILED_TO_UPDATE_USER_STATUS = "1900";
    public static final String PASSWORDS_DO_NOT_MATCH                          = "1901";
    public static final String PASSWORD_MUST_BE_AT_LEAST_8_CHARACTERS_LONG    = "1902";
    public static final String PASSWORD_MUST_NOT_CONTAIN_SPACES                = "1903";
    public static final String PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_UPPERCASE_LETTER = "1904";
    public static final String PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_LOWERCASE_LETTER = "1905";
    public static final String PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_NUMBER       = "1906";
    public static final String PASSWORD_MUST_CONTAIN_AT_LEAST_ONE_SPECIAL_CHARACTER = "1907";
    public static final String NEW_PASSWORD_MUST_BE_DIFFERENT_FROM_CURRENT_PASSWORD = "1908";
    public static final String FAILED_TO_SAVE_AIM_USER = "1909";
    public static final String USER_ROLE_IS_INACTIVE = "1910";
    public static final String USER_COMPANY_IS_INACTIVE = "1911";
    public static final String USER_DOES_NOT_BELONG_TO_PORTAL = "1912";
    public static final String REDIRECT_URI_MISSING = "1913";
    public static final String INVALID_FLOW_TYPE = "1914";
    public static final String INVALID_REDIRECT_URI = "1915";
    public static final String INVALID_RESPONSE_TYPE = "1916";
    public static final String CLIENT_ID_NOT_FOUND = "1917";
    public static final String REFRESH_TOKEN_NOT_FOUND = "1918";
    public static final String INVALID_CLIENT_ID = "1919";
    public static final String REST_CALL_FAILED = "1920";
	public static final String INVALID_CODE_CHALLENGE = "1921";
	 public static final String FAILED_TO_SAVE_SERVICE_TOKEN = "1922";
	 public static final String CLIENT_SECRET_NOT_FOUND = "1923";
	 public static final String UNSUPPORTED_SCOPE_REQUESTED = "1924";
	 public static final String INVALID_PROMPT = "1925";
	 public static final String LOGIN_SESSION_EXPIRED = "1926";
	 public static final String UNSUPPORTED_RESPONSE_TYPE = "1927";
	 public static final String PASSWORD_UPDATE_FAILED = "1928";
	 public static final String AUTH_CODE_EXPIRED = "1929";
	 public static final String USER_SESSION_UPDATE_FAILED = "1930";
	 public static final String USER_SESSION_KILL_OPERATION_CANCELED = "1931";

	// -------------------- Bulk Payment ---------------------

	public static final String FILE_FORMAT_REQUIRED = "2003";
	public static final String INVALID_DEBIT_ACCOUNT = "2004";
	public static final String VALUE_DATE_REQUIRED = "2005";
	public static final String JOB_NOT_FOUND = "2006";
	public static final String EMPTY_FILE = "2007";
	public static final String INVALID_FILE_NAME = "2008";
	public static final String INVALID_FILE_TYPE = "2009";
	public static final String FILE_PATH_NOT_CONFIGURED = "2010";
	public static final String STATUS_CODE_NOT_FOUND = "2010";
	public static final String FILE_PROCESSING_FAILED = "2011";
	public static final String ACCOUNT_NOT_FOUND = "2012";
	public static final String INVALID_JOB_PROCESS_ID = "2013";
	public static final String REJECT_NOTES_REQUIRED = "2014";
	public static final String INVALID_REJECT_STATUS = "2015";
	public static final String INVALID_GXJOB_NAME = "2016";
	public static final String INVALID_BULK_TYPE_STATUS = "2017";
	public static final String INVALID_UNIQUE_KEY = "2018";
	public static final String ALREADY_PRCESSED = "2019";
	public static final String ALREADY_REJECTED = "2020";
	public static final String INVALID_GXLOOKUP_TYPE = "2021";
	public static final String INVALID_ACTION = "2022";
	public static final String INVALID_REJECT_ACTION_FROM_CURRENT_STATUS = "2023";
	public static final String AUTHZ_TYPE_REQUIRED = "2024"; // APPROVAL_STATUS_REQUIRED
	public static final String APPROVAL_STATUS_REQUIRED = "2025";
	public static final String REMARK_REQUIRED = "2026";
	public static final String BULK_TYPE_MISSING = "2027";
	public static final String INVALID_JOBID_FOR_SELECTED_BULK_TYPE = "2028";
	public static final String FILE_REQUIRED = "2029";
	public static final String INVALID_ACTION_FILE_IS_NOT_READY_FOR_REVIEW = "2030";
	public static final String REJECT_NOTES_MAX_LENGTH_EXCEEDED = "2031";
	public static final String INVALID_VALUE_DATE_PAST = "2032";

	public static final String QUERY_EXECUTION_FAILED = "2033";
	public static final String FILE_NAME_EXIST = "2034";
	public static final String BULK_TYPE_REQUIRED = "2035";
	public static final String FILE_ALREADY_EXISTS_TRY_WITH_NEW_FILE = "2036";

	public static final String FILE_PATH_NOT_EXISTS = "2037";
	public static final String FAILED_TO_MOVE_FILE = "2038";
	public static final String FILE_PATH_NOT_EXISTS_IN_EXEC_PROCESS = "2039";

	public static final String SELF_UPDATE_NOT_ALLOWED = "2040";
	public static final String PAYMENTTYPE_OR_CURRENCY_TYPE_MISSING = "2041";
	public static final String INVALID_STATUS_ID = "2042";
	public static final String FILE_READ_FAILED = "2043";
	public static final String INVALID_FILE_DATA = "2044";
	public static final String FORMULA_NOT_ALLOWED = "2045";
	public static final String INVALID_ACTION_FILE_IS_NOT_READY_FOR_CONSENT_AUTHORIZATION = "2046";
	public static final String NO_CONFIGURATION_FOUND_FOR_THE_CURRENT_BANK = "2047";
	public static final String NONCE_ID_EXPIRED = "2048";
	public static final String NONCE_URI_MISMATCH = "2049";
	public static final String FILE_EXTENSION_IS_INVALID = "2050";
	public static final String FILE_EXTENSION_IS_MISMATCH_WITH_THE_UPLOADED_FILE = "2051";



	


	public static final String DATABASE_ERROR = null;
	public static final String INVALID_DATASOURCE_CONFIG = null;
	public static final String DATABASE_CONNECTION_FAILED = null;
	
	public static final String DATABASE_EXCEPTION = "5001";
	public static final String KARTHI_EXCEPTION = "5002";
	public static final String GENERIC_EXCEPTION = "5003";
	public static final String SQL_EXCEPTION = "5004";
	
	// ─── Bill Payments Domain (2100–2124) ─────────────────────────────────────
	public static final String BILL_PAYMENT_INVALID_USER_ID             = "2100";
	public static final String BILL_PAYMENT_INVALID_SME_COMP_ID         = "2101";
	public static final String BILL_PAYMENT_INVALID_PAYEE_REQUEST       = "2102";
	public static final String BILL_PAYMENT_INVALID_TRANSACTION_REQUEST = "2103";
	public static final String BILL_PAYMENT_CATEGORY_FETCH_ERROR        = "2104";
	public static final String BILL_PAYMENT_BILLER_FETCH_ERROR          = "2105";
	public static final String BILL_PAYMENT_SERVICE_FETCH_ERROR         = "2106";
	public static final String BILL_PAYMENT_PARAM_FETCH_ERROR           = "2107";
	public static final String BILL_PAYMENT_PAYEE_SAVE_ERROR            = "2108";
	public static final String BILL_PAYMENT_PAYEE_FETCH_ERROR           = "2109";
	public static final String BILL_PAYMENT_PAYEE_DELETE_ERROR          = "2110";
	public static final String BILL_PAYMENT_SAVE_ERROR                  = "2111";
	public static final String BILL_PAYMENT_FETCH_ERROR                 = "2112";
	public static final String BILL_PAYMENT_SO_CREATE_ERROR             = "2113";
	public static final String BILL_PAYMENT_SO_FETCH_ERROR              = "2114";
	public static final String BILL_PAYMENT_AUTHZ_SAVE_ERROR            = "2115";
	public static final String BILL_PAYMENT_INVALID_AMOUNT              = "2116";
	public static final String BILL_PAYMENT_INVALID_BANK_ID             = "2117";
	public static final String BILL_PAYMENT_USER_ENTITLEMENT_ERROR      = "2118";
	public static final String BILL_PAYMENT_CASA_ACCOUNT_ERROR          = "2119";
	public static final String BILL_PAYMENT_FAVOURITE_PROVIDERS_ERROR   = "2120";
	public static final String BILL_PAYMENT_SERVICE_UNAVAILABLE         = "2121";
	public static final String BILL_PAYMENT_DOWNSTREAM_ERROR            = "2122";
	public static final String BILL_PAYMENT_DEBIT_ACCOUNT_ERROR         = "2123";
	public static final String BILL_PAYMENT_PARAM_MAPPING_ERROR         = "2124";
	public static final String BILL_PAYMENT_INITIATE_ERROR              = "2125";
	public static final String BILL_PAYMENT_APPROVAL_REJECTED           = "2126";
	public static final String BILL_PAYMENT_APPROVAL_ERROR              = "2127";
	public static final String BILL_PAYMENT_ALREADY_PROCESSED           = "2128";
	public static final String BILL_PAYMENT_TRANSACTION_NOT_FOUND       = "2129";
	public static final String PAYMENT_TYPE_FETCH_ERROR                 = "2130";
	
	
	//================================accounts========================================
	public static final String DIRECT_DEBITS_NOT_FOUND = "2131";
	public static final String DIRECT_DEBITS_NOT_FOUND_FOR_STATUS = "2132";
	public static final String DATE_NOT_FOUND = "2133";
	public static final String STATEMENT_GENERATION_FAILED = "2134";
	
	
	
	//================================Alternative Dashboard========================================
	public static final String INPUT_CURRENCY_MISSING = "2501";
	public static final String UPCOMING_PAYMENT_FAILED = "2502";
	public static final String FETCH_CUSTOMER_ACCOUNT_FEIGNCLIENT_ERROR = "2503";
	public static final String AWAITING_APPROVAL_LIST_FAILED = "2504";
	public static final String AWAITING_APPROVAL_COUNT_FAILED = "2505";
	public static final String CUSTOMERS_DATA_NULL_OR_EMPTY = "2506";
	public static final String REPAIR_COUNT_FUNCTION_FAILED = "2507";
	public static final String APPROVAL_COUNTS_FAILED = "2508";
	public static final String REPAIR_LIST_FUNCTION_FAILED = "2509";
	public static final String FETCH_CUSTOMER_ACCOUNT_FEIGNCLIENT_NULL = "2510";
	public static final String CHANNEL_IS_NULL = "2511";
	public static final String LAYOUT_ID_IS_NULL = "2512";
	public static final String LAYOUT_OBJECT_IS_NULL = "2513";


		
	public static final String BANK_API_ERROR = "2603";
	public static final String TIMEOUT_ERROR = "2604";
	public static final String HTTP_METHOD_MISMATCH = "2607";
	public static final String JOLT_TRANSFORMATION_ERROR = "2608";

	// SMS Integration Adapter — 2700 to 2719
	public static final String SMS_REQUEST_NULL = "2700";
	public static final String SMS_MOBILE_NO_EMPTY = "2701";
	public static final String SMS_MOBILE_NO_INVALID = "2702";
	public static final String SMS_MESSAGE_TEXT_EMPTY = "2703";
	public static final String SMS_IDEMPOTENCY_KEY_EMPTY = "2704";
	public static final String SMS_REFERENCE_EMPTY = "2705";
	public static final String SMS_PROVIDER_NOT_CONFIGURED = "2706";
	public static final String SMS_DISPATCH_FAILED = "2707";
	public static final String SMS_RECORD_NOT_FOUND = "2708";
	public static final String SMS_PROVIDER_UNAVAILABLE = "2709";
	public static final String SMS_PROVIDER_NOT_SUPPORTED = "2710";
	public static final String SMS_PROVIDER_NOT_RESOLVED = "2711";
	public static final String SMS_PROVIDER_THROTTLED = "2712";
	public static final String SMS_PROVIDER_INTERNAL_ERROR = "2713";
	public static final String SMS_PROVIDER_INVALID_PARAMETER = "2714";
	public static final String SMS_PROVIDER_AUTH_FAILED = "2715";

	// Wealth login (6000 block)
	public static final String PASSWORD_TOO_SHORT = "6001";
	public static final String PASSWORD_TOO_LONG = "6002";
	public static final String TOO_MANY_LOGIN_ATTEMPTS = "6003";
	public static final String ADMIN_ONLY_ACTION = "6004";

	// Wealth admin: roles and menus
	public static final String ROLE_LOCKED = "6005";
	public static final String UNKNOWN_ROLE = "6006";
	public static final String UNKNOWN_MENU = "6007";
	public static final String CHOOSE_A_MENU = "6008";

	// Wealth accounts
	public static final String WEALTH_ACCOUNT_NOT_FOUND = "6009";

	// Wealth admin: service addresses
	public static final String CONNECTION_ADDRESS_INVALID = "6010";
	public static final String CONNECTION_NOT_UP = "6011";

	// Wealth admin: environment config (host:port settings)
	public static final String ENVIRONMENT_ADDRESS_INVALID = "6012";
	public static final String ENVIRONMENT_CREDENTIALS_INVALID = "6013";
	public static final String SETTINGS_KEY_MISSING = "6014";
	public static final String SERVICE_KEY_REJECTED = "6015";
	public static final String MENU_NEEDS_PARENT = "6016";
	public static final String ROLE_EXISTS = "6017";
	public static final String LAST_ADMIN = "6018";
	public static final String OWN_ROLE = "6019";
	public static final String ROLE_NAME_INVALID = "6020";
	public static final String PROVIDER_INVALID = "6021";
	public static final String PROVIDER_NOT_FOUND = "6022";
	public static final String CREDENTIALS_INCOMPLETE = "6023";
	public static final String BROKER_FETCH_FAILED = "6024";
	public static final String REFRESH_TIME_INVALID = "6025";
	public static final String ACCOUNT_TYPE_INVALID = "6026";
	public static final String ACCOUNT_DETAILS_INVALID = "6027";
	public static final String ACCOUNT_CURRENCY_INVALID = "6028";
	public static final String FD_TERMS_INVALID = "6029";
	public static final String ACCOUNT_EXISTS = "6030";
	public static final String BALANCE_NOT_ALLOWED = "6031";
	public static final String BALANCE_INVALID = "6032";
	public static final String HOLDING_INVALID = "6033";
	public static final String HOLDING_ACCOUNT_INVALID = "6034";
	public static final String TRANSACTION_INVALID = "6040";
	public static final String TRANSACTION_ACCOUNT_INVALID = "6041";
	public static final String TRANSACTION_REFERENCE_EXISTS = "6042";
	public static final String WORKFLOW_NOT_FOUND = "6043";
	public static final String WORKFLOW_DECISION_INVALID = "6044";
	public static final String GMAIL_NOT_CONFIGURED = "6035";
	public static final String GMAIL_REQUEST_INVALID = "6036";
	public static final String GMAIL_CONNECT_FAILED = "6037";
	public static final String GMAIL_NOT_CONNECTED = "6038";
	public static final String GMAIL_FETCH_FAILED = "6039";
	
//		public static final String DIRECT_DEBITS_NOT_FOUND_FOR_STATUS = "2132";
//		public static final String DATE_NOT_FOUND = "2133";


}
