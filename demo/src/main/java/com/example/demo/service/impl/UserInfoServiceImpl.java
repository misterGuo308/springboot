package com.example.demo.service.impl;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.UserInfo;
import com.example.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserInfoMapper userInfoMapper ;

    @Override
    public int insert(UserInfo userInfo) {
        int i = userInfoMapper.insert(userInfo);
        logger.info("新增主键id为:"+  userInfo.getId());
        return i;
    }

    @Override
    public UserInfo findUserInfoById(Integer id) {
        return userInfoMapper.findUserInfoById(id);
    }

    @Override
    public int update(UserInfo userInfo) {
        return userInfoMapper.update(userInfo);
    }

    @Override
    public int delete(Integer id) {
        return userInfoMapper.delete(id);
    }
}
