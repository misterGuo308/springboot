package com.example.demo.jop;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail testJobDetail(){
        return JobBuilder.newJob(TestQuartz.class).withIdentity("testQuartz").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2) //设置定时时间
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(testJobDetail()).withIdentity("testQuartz").withSchedule(scheduleBuilder).build();
    }
}
