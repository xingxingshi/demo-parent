package com.hzq.demo.control.widget;

import com.hzq.demo.service.widget.WidgetService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HZQ
 * @description
 * @Date: 2019-06-04
 * @Time: 09:34
 */
@Api("控件相关接口")
@RequestMapping("/widget")
@RestController
public class WidgetController {

    @Autowired
    private WidgetService widgetService;
}
