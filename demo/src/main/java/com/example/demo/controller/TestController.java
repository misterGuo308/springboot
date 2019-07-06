package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private TestService testService;
    @GetMapping(name = "/get")
    public  String get(){
        int i = 1;
        String s = new String();
        if(i>10){
            System.out.println("1234");
        }
        return testService.get();

    }
}
