package com.hzq.test.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2025/9/2 10:39
 * @Version: 1.0
 */
public class TestMultipleThread {


    private  static  final Object lock = new Object();
    private  static  boolean turn = true;

    @Test
    public void testWaitNotify(){
        System.out.println("测试轮流输出");
        Thread threadNumber = new Thread(() ->{
            for (int i = 1; i <= 26; i++) {
                synchronized (lock) {
                    while (!turn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(i);
                    turn = false;
                    lock.notifyAll();
                }
            }
        });
        Thread threadChat = new Thread(() -> {
            for (char j = 'a'; j <= 'z'; j++) {
                synchronized (lock) {
                    while (turn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(j);
                    turn = true;
                    lock.notifyAll();
                }
            }
        });
        threadNumber.start();
        threadChat.start();
    }

    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();
    private static Condition numberCondition = REENTRANT_LOCK.newCondition();
    private static Condition letterCondition = REENTRANT_LOCK.newCondition();

    @Test
    public void testLock(){
        turn = true;
        Thread threadNumber = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                REENTRANT_LOCK.lock();
                try {
                    while (!turn) {
                        numberCondition.await();
                    }
                    System.out.print(i);
                    turn = false;
                    letterCondition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    REENTRANT_LOCK.unlock();
                }
            }
        });
        Thread threadChat = new Thread(() -> {
            for (char i = 'a'; i <= 'z'; i++) {
                REENTRANT_LOCK.lock();
                try {
                    while (turn) {
                        letterCondition.await();
                    }
                    System.out.println(i);
                    turn = true;
                    numberCondition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    REENTRANT_LOCK.unlock();
                }
            }
        });
        threadNumber.start();
        threadChat.start();

    }




}
