package com.example.demo.service;

import com.example.demo.model.UserInfo;

public interface UserInfoService {



    int insert(UserInfo userInfo);
    UserInfo findUserInfoById(Integer id);

    int update(UserInfo userInfo);

    int delete(Integer id);
}
