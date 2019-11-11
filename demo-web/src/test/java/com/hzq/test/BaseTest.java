package com.hzq.test;

import com.hzq.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author HZQ
 * @description 测试通用配置
 * @Date: 2019-11-11
 * @Time: 14:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})// 指定启动类
@Slf4j
public class BaseTest {

}
