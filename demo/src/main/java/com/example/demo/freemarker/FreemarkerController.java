package com.example.demo.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreemarkerController {

    @GetMapping(value = "/freemarker.do")
    public  String freemarkerShow(){
       return "fm";
    }



}
