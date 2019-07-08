package com.example.demo.service.impl;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.model.UserInfo;
import com.example.demo.service.UserInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public int insert(UserInfo userInfo) {
        int i = userInfoMapper.insert(userInfo);
        logger.info("新增主键id为:" + userInfo.getId());
        //  int a =1/0;
        return i;
    }

    @Override
    public UserInfo findUserInfoById(Integer id) throws IOException {
        Object object = redisTemplate.opsForValue().get("userInfo" + id);

        if (object != null || object.toString().equals("null")) {
            logger.info("进入redis");
            return objectMapper.readValue(object.toString(), UserInfo.class);
        }

        UserInfo userInfo = userInfoMapper.findUserInfoById(id);
        String userInfoJson = "null";
        String userKey = "userInfo" + id;
        if (userInfo != null) {
            userInfoJson = objectMapper.writeValueAsString(userInfo);
            userKey = userKey + userInfo.getId();
        }
        redisTemplate.opsForValue().set(userKey, userInfoJson);
        return userInfo;
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
