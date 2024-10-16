package com.yx.shgd.common.config.interceptor;

import cn.hutool.core.lang.UUID;
import com.yx.shgd.common.config.authorization.AuthUser;
import com.yx.shgd.common.config.authorization.SecurityUtil;
import com.yx.shgd.utils.MdcUtils;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Component
public class TraceIdInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		MdcUtils.setTraceId(UUID.fastUUID().toString(true));
		try {
			AuthUser user = SecurityUtil.getUser();
			if(user != null) {
				MdcUtils.setUserId(user.getUserId() + "");
				MdcUtils.setUserName(user.getUsername());
			}
		} catch (Exception e) {
			log.error("traceId interceptor error: {}", e.getMessage(), e);
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		MdcUtils.clear();
	}
}
