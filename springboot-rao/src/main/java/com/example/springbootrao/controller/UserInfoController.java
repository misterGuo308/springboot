package com.example.springbootrao.controller;


import com.example.springbootrao.common.ret.RetJson;
import com.example.springbootrao.service.UserInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guoyou
 * @since 2019-07-08
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;
    @GetMapping(value = "/get1")
    public String getTest() throws JsonProcessingException {
        return RetJson.makeOKRsp(userInfoService.selectById(2));

    }


}

