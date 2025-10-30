package com.hzq.test.thread;

/**
 * @description: https://blog.csdn.net/u012723673/article/details/80682208
 * @author: HZQ
 * @createDate: 2024/6/6 15:54
 * @Version: 1.0
 */
public class TestVolatile {

    public volatile int inc = 0;

    public void add(){
        inc ++;
    }

    public static void main(String[] args) {
        TestVolatile test = new TestVolatile();
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    //非原子操作，加不到一万
                    for (int j = 0; j < 1000; j++) {


                        test.add();
                        //System.out.println("-----"+test.inc);
                    }
                }
            }.start();
        }
        while (Thread.activeCount()> 1) {
            System.out.println(Thread.activeCount());
            Thread.yield();
        };
        System.out.println(test.inc);
    }
}
