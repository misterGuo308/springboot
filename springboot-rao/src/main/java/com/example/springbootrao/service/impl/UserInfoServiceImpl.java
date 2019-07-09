package com.example.springbootrao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootrao.common.constant.SysConstants;
import com.example.springbootrao.common.ret.RetCode;
import com.example.springbootrao.common.ret.RetJson;
import com.example.springbootrao.listener.MySessionContent;
import com.example.springbootrao.common.model.UserInfo;
import com.example.springbootrao.mapper.UserInfoMapper;
import com.example.springbootrao.service.UserInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Wrapper;

import static com.alibaba.druid.sql.visitor.SQLEvalVisitorUtils.eq;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author guoyou
 * @since 2019-07-08
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public String login(UserInfo userInfo, HttpServletRequest request) throws JsonProcessingException {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("account", userInfo.getAccount());
        wrapper.eq("password", userInfo.getPassword());
        UserInfo user = baseMapper.selectOne(wrapper);
        if (user == null) return RetJson.makeRsp(RetCode.FAIL, "用户名或密码不正确");
        String sessionId = (String) redisTemplate.opsForValue().get(userInfo.getAccount());
        if (sessionId != null) {
            redisTemplate.opsForValue().set(sessionId,SysConstants.AUTO);
            redisTemplate.delete(userInfo.getAccount());
        }
        //将用户信息实例化Session中
        HttpSession session = request.getSession();
        session.setAttribute(SysConstants.USER_INFO, userInfo);
        redisTemplate.opsForValue().set(userInfo.getAccount(), session.getId());
        return RetJson.makeOKRsp();
    }

    @Override
    public String logout(HttpServletRequest request) throws JsonProcessingException {

        request.getSession().removeAttribute(SysConstants.USER_INFO);
        return RetJson.makeOKRsp();
    }
}
