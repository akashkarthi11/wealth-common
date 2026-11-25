package com.wealth.common.constants;

public final class QueryConstants {

    private QueryConstants() {
        // prevent instantiation
    }

    public static final String FIND_ALL =
            "SELECT * FROM ";

    public static final String GET_USER_ID_FROM_USER_CODE =
    		"SELECT sme_comp_id AS id FROM GXSME_COMP_USER WHERE user_code = ? " ;

//    public static final String GET_BANK_BRANCH_DETAIL =
//            "SELECT bank_branch_id, global_bank_id, branch_name, branch_address, branch_coordinates, branch_ifsc_code, branch_swift_code, branch_code, city, state, record_state, crtd_ip, crtd_by, crtd_dt, updt_ip, updt_by, updt_dt FROM GXSYS_GLOBAL_BANK_BRANCH GB " +
//            "WHERE BRANCH_SWIFT_CODE = ? AND RECORD_STATE = 'A'";
}
