package com.example.springbootrao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootrao.common.model.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guoyou
 * @since 2019-07-08
 */
public interface UserInfoService extends IService<UserInfo> {

    String login(UserInfo userInfo, HttpServletRequest request) throws JsonProcessingException;

    String logout(HttpServletRequest request) throws JsonProcessingException;
}
