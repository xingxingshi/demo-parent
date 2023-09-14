package com.hzq.demo.threads;

/**
 * @author HZQ
 * @description
 * @Date: 3/9/21
 * @Time: 2:35 PM
 */
public class ThreadDemo {


    public static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("MyThread--------run--"+Thread.currentThread().getId());
        }

    }


    public static void main(String[] args) {


        System.out.println("执行main所在线程的线程组名字： " + Thread.currentThread().getThreadGroup().getName());


        MyThread myThread = new MyThread();
        myThread.run();
        myThread.run();
        myThread.start();

        new Thread(()->{
            System.out.println("ddddddd--"+Thread.currentThread().getId());
            System.out.println("testThread线程名字：" + Thread.currentThread().getName());
            System.out.println("testThread当前线程组名字：" + Thread.currentThread().getThreadGroup().getName());
        }).start();


    }
}
