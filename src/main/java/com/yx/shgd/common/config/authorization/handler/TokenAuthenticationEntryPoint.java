package com.yx.shgd.common.config.authorization.handler;

import cn.hutool.json.JSONUtil;
import com.yx.shgd.common.config.handler.ResultBean;
import com.yx.shgd.common.exception.BaseErrorCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录处理器
 * @author HU
 * @date 2022/1/20 10:52
 */

@Component
public class TokenAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) throws IOException {
        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(JSONUtil.toJsonStr(new ResultBean<>(BaseErrorCode.NOT_LOGIN)));
        response.flushBuffer();
    }
}
