package com.example.demo.service;

import com.example.demo.model.UserInfo;

import java.io.IOException;

public interface UserInfoService {


    int insert(UserInfo userInfo);

    UserInfo findUserInfoById(Integer id) throws IOException;

    int update(UserInfo userInfo);

    int delete(Integer id);
}
