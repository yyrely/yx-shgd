package com.yx.shgd.common.config.authorization;

import java.lang.annotation.*;

/**
 * 匿名访问注解
 * @author HU
 * @date 2022/1/24 17:36
 */

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnonymousAccess {
}
