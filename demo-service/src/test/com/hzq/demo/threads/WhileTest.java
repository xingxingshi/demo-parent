package com.hzq.demo.threads;

import lombok.extern.slf4j.Slf4j;

/**
 * @author HZQ
 * @Date: 2021/4/27
 * @Time: 10:56 上午
 * @description
 */
@Slf4j
public class WhileTest {

    private static ThreadLocal<String> local = ThreadLocal.withInitial(() -> "init");

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new TT();
        new Thread(r, "thread1").start();
        Thread.sleep(2000);
        new Thread(r, "thread2").start();
        log.info("exit");
    }

    private static class TT implements Runnable {
        @Override
        public void run() {
            log.info(local.get());
            local.set(Thread.currentThread().getName());
            log.info("set local name and get: {}", local.get());
        }
    }
}
