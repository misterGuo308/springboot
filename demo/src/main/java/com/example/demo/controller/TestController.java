package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TestService testService;

    @GetMapping(value = "/get")
    @ResponseBody
    public String get() {
        int i = 1;
        String s = new String();
        if (i > 10) {
            System.out.println("1234");
        }
        logger.info("测试日志");
        return testService.get();

    }


    @GetMapping(value = "/index.do")
    public String geta() {
        return "index.html";

    }
}
