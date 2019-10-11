package com.hzq.demo.service.impl.widget;

import com.hzq.demo.dao.ext.WidgetExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-04
 * @Time: 09:27
 */
@Service
public class WidgetServiceImpl implements WidgetService {

    @Autowired
    private WidgetExtMapper widgetExtMapper;
}

