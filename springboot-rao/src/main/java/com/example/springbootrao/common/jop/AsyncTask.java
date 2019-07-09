package com.example.springbootrao.common.jop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Async
//@Component
public class AsyncTask {


    private Logger logger = LoggerFactory.getLogger(AsyncTask.class);
    /**
     * @EnableAsync：开启异步事件的支持 然后在定时任务的类或者方法上添加@Async
     */

    @Scheduled(cron = "0/2 * * * * *")
    public void scheduledTask(){
        logger.info("定时任务"+new Date());
    }
}
