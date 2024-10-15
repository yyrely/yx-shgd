package com.yx.shgd.common.config.authorization.handler;

import cn.hutool.json.JSONUtil;
import com.yx.shgd.common.config.handler.ResultBean;
import com.yx.shgd.common.exception.BaseErrorCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆失败处理器
 * @author HU
 * @date 2022/1/20 10:52
 */

@Component
public class PostJsonAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException exception) throws IOException {
        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(JSONUtil.toJsonStr(new ResultBean<>(BaseErrorCode.LOGIN_FAIL)));
        response.flushBuffer();
    }
}
