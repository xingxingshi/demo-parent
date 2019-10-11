package com.hzq.demo.common.core;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-03
 * @Time: 10:13
 */
public class PageReqBase implements Serializable {

    
    @ApiModelProperty(value = "当前页")
    private Integer pageNumber;

    @ApiModelProperty(value = "每页条数")
    private Integer pageSize;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
