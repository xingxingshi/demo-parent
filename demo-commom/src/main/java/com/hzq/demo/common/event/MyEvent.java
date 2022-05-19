package com.hzq.demo.common.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author HZQ
 * @description
 * @Date: 2020-08-25
 * @Time: 14:43
 */
public class MyEvent extends ApplicationEvent {

    private String desc;

    public MyEvent(Object source,String desc) {
        super(source);
        this.desc = desc;
    }

    public MyEvent(Object source) {
        super(source);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
