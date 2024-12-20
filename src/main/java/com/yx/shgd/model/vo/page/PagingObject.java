package com.yx.shgd.model.vo.page;

import java.io.Serializable;
import java.util.List;

/**
 * @author HU
 * @date 2021/3/5 11:50
 */

public interface PagingObject<T> extends Iterable<T>, Serializable {

	/**
	 * 页码
	 *
	 * @return
	 */
	long getPage();

	/**
	 * 分页大小
	 *
	 * @return
	 */
	long getSize();

	/**
	 * 总页数
	 *
	 * @return
	 */
	int getTotal();

	/**
	 * 总记录数
	 *
	 * @return
	 */
	long getTotalElements();

	/**
	 * 分页内容记录数
	 *
	 * @return
	 */
	int getNumberOfElements();

	/**
	 * 是否有上一页
	 *
	 * @return
	 */
	boolean hasPrevious();

	/**
	 * 是否有下一页
	 *
	 * @return
	 */
	boolean hasNext();

	/**
	 * 是否是第一页
	 *
	 * @return
	 */
	boolean isFirst();

	/**
	 * 是否是最后一页
	 *
	 * @return
	 */
	boolean isLast();

	/**
	 * 是否有分页内容
	 *
	 * @return
	 */
	boolean hasRecords();

	/**
	 * 获取分页内容
	 *
	 * @return
	 */
	List<T> getRecords();
}
