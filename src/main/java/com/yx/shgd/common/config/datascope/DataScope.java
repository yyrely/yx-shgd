/*
 *    Copyright (c) 2018-2025, btbc All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: btbc
 */

package com.yx.shgd.common.config.datascope;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 数据权限查询参数
 * @author Hu
 * @since 2022-01-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DataScope extends HashMap {

	/**
	 * 限制范围的字段名称
	 */
	private String scopeName = "dept_id";

	/**
	 * 具体的数据范围
	 */
	private List<Long> deptIds = new ArrayList<>();

	/**
	 * 是否只查询本部门
	 */
	private Boolean isOnly = false;

	/**
	 * 函数名称，默认 SELECT * ;
	 *
	 * <ul>
	 * <li>COUNT(1)</li>
	 * </ul>
	 */
	private DataScopeFuncEnum func = DataScopeFuncEnum.ALL;

}
