package com.hzq.demo.control.study;

import com.hzq.demo.common.core.Result;
import com.hzq.demo.service.study.StudyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2025/8/5 18:25
 * @Version: 1.0
 */
@RestController
@Api("学习相关接口")
@RequestMapping("/studyControl")
@Slf4j
public class StudyControl {

    @Autowired
    private StudyService studyService;

    @RequestMapping(value = "/testMultiThread",method = RequestMethod.GET)
    @ApiOperation(value = "测试多线程")
    public Result<Boolean> testMultiThread(@RequestParam @ApiParam(value = "测试多线程", required = true) Integer idea){
        studyService.testMultiThread(idea);
        return Result.success(Boolean.TRUE);
    }

    @RequestMapping(value = "/testAsyncThread",method = RequestMethod.GET)
    @ApiOperation(value = "测试异步线程")
    public Result<Boolean> testAsyncThread(@RequestParam @ApiParam(value = "测试异步线程", required = true) Integer idea){
        System.out.println("current control thread "+Thread.currentThread());
        for (int index = 0; index < idea; index++) {
            studyService.testAsyncThread(index);
        }
        log.info("结束了");
        return Result.success(Boolean.TRUE);
    }



}
