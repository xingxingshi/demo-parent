package com.hzq.demo.threads;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2026/9/3 14:24
 * @Version: 1.0 https://blog.csdn.net/m0_72410274/article/details/139219844
 */
public class TestFuture {

    @Test
    public void testSupplyAsync() {
        System.out.println(Thread.currentThread().getName());

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            return "hello";
        });

        String s = null;
        try {
            s = future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);

    }


    @Test
    public void testHandle() throws Exception{
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            throw  new RuntimeException("；");
        });
        CompletableFuture<String> handle = future.handle((result, throwable) -> {
            if (throwable != null) {
                System.out.println(throwable.getMessage());
            }
            return result;
        });
        System.out.println(handle.get());

    }



}