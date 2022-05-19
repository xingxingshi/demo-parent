package com.hzq.demo.common.event;

/**
 * @author HZQ
 * @description
 * @Date: 2020-08-25
 * @Time: 15:38
 */
public class DemoEvent {

    private String desc;

    public DemoEvent(String desc){
        this.desc=desc;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
