package com.hzq.demo.model.auto;

import lombok.Data;

import java.util.Date;

/**
 * demo_sys_log
 */
@Data
public class SysLog {
    /**
     * 主键id
     */
    private Integer id;

    /**
     */
    private String className;

    /**
     */
    private String methodName;

    /**
     */
    private Long exeuTime;

    /**
     */
    private String remark;

    /**
     */
    private Date createDate;
}