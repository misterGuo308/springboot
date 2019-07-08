package com.example.demo.jop;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/*@Async
@Component*/
public class AsyncTest {

    /**
     * @EnableAsync：开启异步事件的支持 然后在定时任务的类或者方法上添加@Async
     */


    // @Scheduled(cron = "0/2 * * * * *")
    public void scheduledTest() {
        System.out.println("scheduled中cron定时任务:" + new Date());
    }

    @Scheduled(fixedRate = 2000)
    public void scheduledTest2() throws Exception {
        Thread.sleep(10000);
        System.out.println("scheduled中fixeRate定时任务" + new Date());

    }

    @Scheduled(fixedDelay = 2000)
    public void scheduledTest3() {
        System.out.println("scheduled中fixedDelay定时任务" + new Date());
    }
}
