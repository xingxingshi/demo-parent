package com.hzq.demo.service.impl.study;

import com.hzq.demo.service.impl.sportsLottery.SportsLotteryServiceImpl;
import com.hzq.demo.service.study.StudyService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: HZQ
 * @createDate: 2025/8/5 18:25
 * @Version: 1.0
 */
@Slf4j
@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    @Qualifier("studyAsyncThreadPool")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    @SneakyThrows
    public Boolean testMultiThread(Integer idea) {
        System.out.println("now out thread "+Thread.currentThread());
        /*for (int i = 0; i < 1000; i++) {
            threadPoolTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("now int thread "+Thread.currentThread());
                }
            });
        }*/
        CountDownLatch countDownLatch = new CountDownLatch(idea);
        for (int i = 1; i <= idea; i++) {
            threadPoolTaskExecutor.submit(new TestTask(idea,i,countDownLatch));
        }
        countDownLatch.await();
        log.info("结束主线程了");
        return null;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    class TestTask implements Runnable {

        private Integer idea;

        private Integer index;

        private CountDownLatch countDownLatch;

        @Override
        public void run() {
            System.out.println(idea + "  now int thread A "+index + " "+Thread.currentThread());
            try {
                Thread.sleep(8000);
            }catch (Exception e){
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println(idea + "  now int thread B "+ index + " " +Thread.currentThread());
        }
    }


    @Async("studyAsyncThreadPool")
    @Override
    public Boolean testAsyncThread(Integer idea) {
        System.out.println(idea + "  now int thread A "+idea + " "+Thread.currentThread());
        try {
            Thread.sleep(8000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(idea + "  now int thread B "+ idea + " " +Thread.currentThread());
        return null;
    }
}
