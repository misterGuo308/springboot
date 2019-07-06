package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Controller
public class TestController {
    @Resource
    private TestService testService;
    @GetMapping(value = "/get")
    @ResponseBody
    public  String get(){
        return testService.get();

    }


    @GetMapping(value = "/index.do")
    public  String geta(){
        return "index.html";

    }
}
