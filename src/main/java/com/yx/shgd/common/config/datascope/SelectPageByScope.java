package com.yx.shgd.common.config.datascope;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author Hu
 * @since 2022-01-21
 */
public class SelectPageByScope extends AbstractMethod {

	@Override
	public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
		SqlMethod sqlMethod = SqlMethod.SELECT_PAGE;
		String sql = String.format(sqlMethod.getSql(), sqlFirst(), sqlSelectColumns(tableInfo, true),
				tableInfo.getTableName(), sqlWhereEntityWrapper(true, tableInfo), sqlComment());
		SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
		return this.addSelectMappedStatementForTable(mapperClass, "selectPageByScope", sqlSource, tableInfo);
	}

}
