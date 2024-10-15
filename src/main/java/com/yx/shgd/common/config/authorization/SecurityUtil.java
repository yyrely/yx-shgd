package com.yx.shgd.common.config.authorization;

import com.yx.shgd.common.exception.BaseErrorCode;
import com.yx.shgd.common.exception.ServiceException;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * 权限工具
 * @author HU
 * @date 2022/1/20 10:52
 */

@UtilityClass
public class SecurityUtil {

    /**
     * 获取Authentication
     * @return 认证信息
     */
    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户信息
     * @return 用户信息
     */
    public AuthUser getUser(){
        try {
            return (AuthUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new ServiceException(BaseErrorCode.NOT_LOGIN, "登录状态过期");
        }
    }

    /**
     * 获取用户角色信息
     * @return 角色集合
     */
    public List<Long> getRoles() {
        return getUser().getRoles();
    }

}
