package com.example.springbootrao.controller;


import com.alibaba.druid.util.StringUtils;
import com.example.springbootrao.common.constant.SysConstants;
import com.example.springbootrao.common.ret.RetCode;
import com.example.springbootrao.common.ret.RetJson;
import com.example.springbootrao.common.model.UserInfo;
import com.example.springbootrao.service.UserInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @GetMapping(value = "/get")
    public String getTest() throws JsonProcessingException {
        return RetJson.makeOKRsp(userInfoService.getById(2));

    }


    @GetMapping(value = "/login")
    public String login(@RequestParam(name = "account") String account , @RequestParam("password") String password , HttpServletRequest request) throws JsonProcessingException {
         if(StringUtils.isEmpty(account)||StringUtils.isEmpty(password))
          return  RetJson.makeRsp(RetCode.FAIL,"用户名或密码不能为空");
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(account);
        userInfo.setPassword(password);
        return userInfoService.login(userInfo,request);
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) throws JsonProcessingException {

        return userInfoService.logout(request);
    }


}

