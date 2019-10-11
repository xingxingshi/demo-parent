package com.hzq.demo.model.auto;

import lombok.Data;

/**
 * demo_sys_log
 */
@Data
public class SysLogWithBLOBs extends SysLog {
    /**
     */
    private String params;

    /**
     */
    private String response;
}