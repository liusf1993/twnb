package com.lsf.twnb.query.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Base class for query
 */
public class PageQuery<T> implements Serializable {
    public static final int DEFAULT_PAGE_SIZE=10;
    public static final int DEFAULT_PAGE_NO=1;
    /**
     * 是否分页,默认不分页
     */
    boolean isPage=false;
    /**
     * 每页条数
     */
    int pageSize=DEFAULT_PAGE_SIZE;

    /**
     * 当前页数数
     */
    int pageNo=DEFAULT_PAGE_NO;
    /**
     * 数据集
     */
    List<T> items;
    /**
     * 是否需要总条数，查询总条数会额外增加一次查询
     */
    boolean isNeedTotalCount=false;

    /**
     * 总条数
     */
    int totalCount=0;

    public boolean isPage() {
        return isPage;
    }

    public void setPage(boolean page) {
        isPage = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public boolean isNeedTotalCount() {
        return isNeedTotalCount;
    }

    public void setNeedTotalCount(boolean needTotalCount) {
        isNeedTotalCount = needTotalCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getOffset() {
        return (pageNo-1)*pageSize;
    }
}
