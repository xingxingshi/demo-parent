package com.hzq.demo.common.listener;

import com.hzq.demo.common.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * @author HZQ
 * @description
 * @Date: 2020-08-25
 * @Time: 15:10
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onApplicationEvent(MyEvent event) {
        String desc= event.getDesc();
        logger.info("MyEventListener receive MyEvent.desc=" +desc);
    }
}
