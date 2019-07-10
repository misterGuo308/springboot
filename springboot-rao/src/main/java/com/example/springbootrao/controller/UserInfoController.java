package com.example.springbootrao.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootrao.common.annotation.AspectLog;
import com.example.springbootrao.common.ret.RetCode;
import com.example.springbootrao.common.ret.RetJson;
import com.example.springbootrao.common.model.UserInfo;
import com.example.springbootrao.common.utils.Verify;
import com.example.springbootrao.service.UserInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * <p>
 * 前端控制器
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


    @GetMapping(value = "/get")
    @AspectLog(operation = "查询用户信息")
    public String getTest() throws JsonProcessingException {
        return RetJson.makeOKRsp(userInfoService.getById(2));

    }


    @GetMapping(value = "/login")
    public String login(@RequestParam(name = "account") String account, @RequestParam("password") String password, HttpServletRequest request) throws Exception {
        Verify.paramIsAnyNull(account, password);
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(account);
        userInfo.setPassword(password);
        return userInfoService.login(userInfo, request);

    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) throws Exception {
        return userInfoService.logout(request);
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody UserInfo userInfo) throws Exception {
        Verify.paramIsAnyNull(userInfo.getAccount(), userInfo.getName(), userInfo.getPassword());
        return userInfoService.register(userInfo);
    }

}

