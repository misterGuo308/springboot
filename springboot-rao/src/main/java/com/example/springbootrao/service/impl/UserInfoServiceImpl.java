package com.example.springbootrao.service.impl;

import com.example.springbootrao.model.UserInfo;
import com.example.springbootrao.mapper.UserInfoMapper;
import com.example.springbootrao.service.UserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guoyou
 * @since 2019-07-08
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
