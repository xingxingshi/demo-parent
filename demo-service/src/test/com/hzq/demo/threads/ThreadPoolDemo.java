package com.hzq.demo.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author HZQ
 * @description
 * @Date: 3/9/21
 * @Time: 4:58 PM
 */
public class ThreadPoolDemo {


    public static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            // 模拟计算需要一秒
            System.out.println("CallableTask------"+Thread.currentThread().getId());
            Thread.sleep(1000);
            return 2;
        }
    }



    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableTask callableTask= new CallableTask();
        System.out.println("main---"+Thread.currentThread().getId());
        Future<Integer> submit = executorService.submit(callableTask);
        System.out.println("main---"+Thread.currentThread().getId());

        // 注意调用get方法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使用可以设置超时时间的重载get方法。
        System.out.println(submit.get() +"----"+Thread.currentThread().getId());


        CallableTask task= new CallableTask();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);
        System.out.println("main---"+Thread.currentThread().getId());
        executorService.submit(integerFutureTask);
        System.out.println("main---"+Thread.currentThread().getId());
        System.out.println(integerFutureTask.get() +"----"+Thread.currentThread().getId());


        //线程池不关，程序不停止
        executorService.shutdown();
    }
}
