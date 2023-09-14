package com.hzq.demo.threads;

import java.util.stream.IntStream;

/**
 * @author HZQ
 * @description
 * @Date: 3/10/21
 * @Time: 6:18 PM
 */
public class PriorityDemo {

    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }

}
