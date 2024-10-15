package com.yx.shgd.common.config.authorization.handler;

import cn.hutool.json.JSONUtil;
import com.yx.shgd.common.config.handler.ResultBean;
import com.yx.shgd.common.exception.BaseErrorCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限不足处理器
 * @author HU
 * @date 2022/1/20 10:52
 */

@Component
public class TokenAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        AccessDeniedException e) throws IOException {
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().print(JSONUtil.toJsonStr(new ResultBean<>(BaseErrorCode.NOT_PERMISSION)));
        httpServletResponse.flushBuffer();
    }
}
