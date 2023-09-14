package com.hzq.demo.threads;

/**
 * @author HZQ
 * @Date: 2021/4/7
 * @Time: 2:08 下午
 * @description
 */
public class ThreadSleepTest {

    public static void main(String[] args) throws Exception {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        /*
        a.start();
        b.start();
        System.out.println(a.getName() + ":" + a.getState() + ":" +a.getId()); // 输出？
        System.out.println(b.getName() + ":" + b.getState() + ":" +b.getId()); // 输出？*/
        /*a.start();
        Thread.sleep(1000L); // 需要注意这里main线程休眠了1000毫秒，而testMethod()里休眠了2000毫秒
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？*/
        a.start();
        a.join();
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出 TERMINATED
        System.out.println(b.getName() + ":" + b.getState());
    }

    // 同步方法争夺锁
    private static synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
