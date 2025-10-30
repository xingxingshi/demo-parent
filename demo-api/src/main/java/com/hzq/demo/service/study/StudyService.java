package com.hzq.demo.service.study;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2025/8/5 18:35
 * @Version: 1.0
 */
public interface StudyService {

    /**
     * 验证多线性
     * @param idea
     * @return
     */
    Boolean testMultiThread(Integer idea);

    /**
     * 测试异步线程
     * @param idea
     * @return
     */
    Boolean testAsyncThread(Integer idea);
}
