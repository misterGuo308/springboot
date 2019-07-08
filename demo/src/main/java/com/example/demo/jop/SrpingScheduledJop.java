package com.example.demo.jop;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
public class SrpingScheduledJop {
    /**
     * scheduled
     * 可以看到三个定时任务都已经执行，
     * 并且使同一个线程中串行执行，
     * 如果只有一个定时任务，这样做肯定没问题，
     * 当定时任务增多，如果一个任务卡死，会导致其他任务也无法执行。
     */

    @Scheduled(cron = "0/2 * * * * *")
    public void scheduledTest() {
        System.out.println("scheduled中cron定时任务:" + new Date());
    }

    @Scheduled(fixedRate = 2000)
    public void scheduledTest2() throws Exception {
        //  Thread.sleep(10000);
        System.out.println("scheduled中fixeRate定时任务" + new Date());

    }

    @Scheduled(fixedDelay = 2000)
    public void scheduledTest3() {
        System.out.println("scheduled中fixedDelay定时任务" + new Date());
    }
}
