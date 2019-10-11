package com.hzq.demo.common.core;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-03
 * @Time: 10:00
 */
public class PageResult<T> implements Serializable {

    /**
     * 页码，从1开始
     */
    @ApiModelProperty(value = "页码，从1开始")
    private int pageNumber;

    /**
     * 页面大小
     */
    @ApiModelProperty("页面大小")
    private int pageSize;

    /**
     * 总数
     */
    @ApiModelProperty("总条数")
    private long total;
    /**
     * 总页数
     */
    @ApiModelProperty("总页数")
    private int pages;

    @ApiModelProperty("查询内容")
    private List<T> date;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getDate() {
        return date;
    }

    public void setDate(List<T> date) {
        this.date = date;
    }
}
