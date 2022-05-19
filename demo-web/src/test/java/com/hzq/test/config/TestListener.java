package com.hzq.test.config;

import com.hzq.demo.common.event.DemoEvent;
import com.hzq.demo.common.event.MyEvent;
import com.hzq.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author HZQ
 * @description
 * @Date: 2020-08-25
 * @Time: 15:19
 */
@Slf4j
public class TestListener extends BaseTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testMyEventListener(){
        log.info("测试MyEventListener开始");
        applicationContext.publishEvent(new MyEvent(this,"testMyEventListener"));
        log.info("测试MyEventListener结束");
    }

    @Test
    public void testDemoEventListener(){
        log.info("测试DemoEventListener开始");
        applicationContext.publishEvent(new DemoEvent("testDemoEventListener"));
        log.info("测试DemoEventListener结束");

    }

}
