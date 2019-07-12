package com.example.springbootrao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootrao.common.model.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guoyou
 * @since 2019-07-08
 */
public interface UserInfoService extends IService<UserInfo> {

    String login(UserInfo userInfo, HttpServletRequest request) throws Exception;

    String logout(HttpServletRequest request) throws Exception;

    String addRegister(UserInfo userInfo) throws Exception;

    /**
     * 测试异常配置文件是否好用代码  注方法名前必须加上配置文件配置相应路径
     * @param userInfo
     * @throws Exception
     */
    void insertregister(UserInfo userInfo) throws Exception;
}
