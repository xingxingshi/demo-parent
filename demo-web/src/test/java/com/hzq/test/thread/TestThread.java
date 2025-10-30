package com.hzq.test.thread;

import org.junit.Test;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2024/4/16 17:52
 * @Version: 1.0
 */
public class TestThread {

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread 当前线程" +Thread.currentThread().getName());
        }
    }

    class MyThreadOne implements Runnable{
        @Override
        public void run() {
            System.out.println("MyThread1 当前线程" +Thread.currentThread().getName());
        }
    }

    @Test
    public void testThread(){
        System.out.println("当前线程"+Thread.currentThread().getName());
        new MyThread().start();
        new MyThread().start();
        MyThreadOne myThreadOne = new MyThreadOne();
        new Thread(myThreadOne).start();
    }
}
