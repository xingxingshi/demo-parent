package com.hzq.demo.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author HZQ
 * @description
 * @Date: 3/10/21
 * @Time: 8:42 PM
 */
public class DaemonThread {


    static class Thread1 extends Thread {

        @Override
        public void run() {
            while(true)
            {
                System.out.println("子线程运行中....");
                try
                {
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();

        ThreadPoolDemo.CallableTask callableTask= new ThreadPoolDemo.CallableTask();
        System.out.println("main---"+Thread.currentThread().getId());
        Future<Integer> submit = executorService.submit(callableTask);
        System.out.println("main---"+Thread.currentThread().getId());


        Thread mainThread = new Thread(new Runnable(){
            public void run()
            {
                System.out.println("主线程开始...");
                Thread sonThread = new Thread(new Thread1());
                sonThread.setDaemon(true);
                sonThread.start();

                try
                {
                    TimeUnit.MILLISECONDS.sleep(10000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("主线程结束");
            }
        });
        mainThread.start();


    }

}
