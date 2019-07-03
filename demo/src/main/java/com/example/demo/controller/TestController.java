package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private TestService testService;
       System.out.println("2");
    @GetMapping(name = "/get")
    public  String get(){
        System.out.println("1");
        return testService.get();

    }
}
