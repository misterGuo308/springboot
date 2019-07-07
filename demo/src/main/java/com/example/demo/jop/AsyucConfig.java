package com.example.demo.jop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

//@Configuration
//@EnableAsync
public class AsyucConfig {
    @Value("${asyucConfig.corePoolSize}")
    private int corePoolSize ;
    @Value("${asyucConfig.maxPoolSize}")
    private  int maxPoolSize ;
    @Value("${asyucConfig.queueCapacity}")
    private  int queueCapacity;

    @Bean
    public Executor testExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}
