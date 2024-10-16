package com.yx.shgd.model.vo.page;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author HU
 * @date 2021/3/5 11:50
 */

public class SimplePagingObject<T> implements PagingObject<T> {

    @ApiModelProperty("页码")
    private final long page;

    @ApiModelProperty("分页大小")
    private final long size;

    @ApiModelProperty("总页数")
    private final int totalPages;

    @ApiModelProperty("总记录数")
    private final long totalElements;

    @ApiModelProperty("分页内容")
    private List<T> content;

    public SimplePagingObject(List<T> content, long page, long size, long totalElements) {
        Assert.isTrue(page > 0, "pageNum must be positive.");
        Assert.isTrue(size > 0, "pageSize must be positive.");
        Assert.isTrue(totalElements >= 0, "totalElements must net be negative.");
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = (int)(totalElements / size + (totalElements % size == 0 ? 0 : 1));
        this.content = content == null ? Collections.EMPTY_LIST : content;
    }

    protected void setContent(List<T> content) {
        this.content = content;
    }

    /**
     * 页码
     *
     * @return
     */
    @Override
    public long getPageNum() {
        return page;
    }

    /**
     * 分页大小
     *
     * @return
     */
	@Override
    public long getPageSize() {
        return size;
    }

    /**
     * 总页数
     *
     * @return
     */
	@Override
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * 总记录数
     *
     * @return
     */
	@Override
    public long getTotalElements() {
        return totalElements;
    }

    /**
     * 分页内容记录数
     *
     * @return
     */
	@Override
    public int getNumberOfElements() {
        return content.size();
    }

    /**
     * 是否有上一页
     *
     * @return
     */
	@Override
    public boolean hasPrevious() {
        return page > 1;
    }

    /**
     * 是否有下一页
     *
     * @return
     */
	@Override
    public boolean hasNext() {
        return page < totalPages;
    }

    /**
     * 是否是第一页
     *
     * @return
     */
	@Override
    public boolean isFirst() {
        return !hasPrevious();
    }

    /**
     * 是否是最后一页
     *
     * @return
     */
	@Override
    public boolean isLast() {
        return !hasNext();
    }

    /**
     * 是否有分页内容
     *
     * @return
     */
	@Override
    public boolean hasContent() {
        return !content.isEmpty();
    }

	@Override
    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    @Override
    public Iterator<T> iterator() {
        return content.iterator();
    }
}
