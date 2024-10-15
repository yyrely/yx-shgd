package com.yx.shgd.common.config.interceptor;

import cn.hutool.core.lang.UUID;
import com.yx.shgd.common.config.authorization.AuthUser;
import com.yx.shgd.common.config.authorization.SecurityUtil;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * traceId拦截器
 * @author HU
 * @date 2022/1/19 14:28
 */

@Component
public class TraceIdInterceptor implements HandlerInterceptor {

	public static final String TRACE_ID = "traceId";
	public static final String USER_NAME = "userName";
	public static final String USER_ID = "userId";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		MDC.put(TRACE_ID, UUID.fastUUID().toString(true));
		try {
			AuthUser user = SecurityUtil.getUser();
			if(user != null) {
				MDC.put(USER_NAME, user.getUsername());
				MDC.put(USER_ID, user.getUserId()+"");
			}
		} catch (Exception e) {

		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		MDC.clear();
	}
}
