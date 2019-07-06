package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TestService testService;
    @GetMapping(name = "/get")
    public  String get(){
      logger.info("测试日志");
        return testService.get();

    }
}
