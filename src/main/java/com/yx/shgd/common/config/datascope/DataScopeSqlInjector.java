package com.yx.shgd.common.config.datascope;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;

/**
 * 支持自定义数据权限方法注入
 *
 * @author Hu
 * @since 2022-01-21
 */
public class DataScopeSqlInjector extends DefaultSqlInjector {

	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
		List<AbstractMethod> methodList = super.getMethodList(mapperClass);
		methodList.add(new SelectListByScope());
		methodList.add(new SelectPageByScope());
		methodList.add(new SelectCountByScope());
		return methodList;
	}

}
