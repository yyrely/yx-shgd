package com.yx.shgd.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class MdcUtils {

    private static final Logger log = LoggerFactory.getLogger(MdcUtils.class);
    public static final String USER_ID_FIELD = "userId";
    public static final String USER_NAME_FIELD = "userName";
    public static final String TRACE_ID_FIELD = "traceId";

    private MdcUtils() {
    }

    public static String getUserId() {
        return MDC.get(USER_ID_FIELD);
    }

    public static void setUserId(String userId) {
        MDC.put(USER_ID_FIELD, userId);
    }

    public static String getUserName() {
        return MDC.get(USER_NAME_FIELD);
    }

    public static void setUserName(String userId) {
        MDC.put(USER_NAME_FIELD, userId);
    }

    public static String getTraceId() {
        return MDC.get(TRACE_ID_FIELD);
    }

    public static void setTraceId(String traceId) {
        MDC.put(TRACE_ID_FIELD, traceId);
    }

    public static void clear() {
        MDC.remove(USER_ID_FIELD);
        MDC.remove(USER_NAME_FIELD);
        MDC.remove(TRACE_ID_FIELD);
    }
}
