package com.hzq.demo.common.listener;

import com.hzq.demo.common.event.DemoEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author HZQ
 * @description
 * @Date: 2020-08-25
 * @Time: 15:39
 */
@Component
public class DemoEventListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener
    public void handleDemoEvent(DemoEvent demoEvent){
        logger.info("DemoEventListener receive DemoEvent.desc=" + demoEvent.getDesc());
    }
}
