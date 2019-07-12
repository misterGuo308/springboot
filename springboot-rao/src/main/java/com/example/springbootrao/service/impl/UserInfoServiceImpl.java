package com.example.springbootrao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootrao.common.constant.SysConstants;
import com.example.springbootrao.common.ret.RetCode;
import com.example.springbootrao.common.ret.RetJson;
import com.example.springbootrao.common.model.UserInfo;
import com.example.springbootrao.common.utils.MD5Utils;
import com.example.springbootrao.common.utils.Verify;
import com.example.springbootrao.mapper.UserInfoMapper;
import com.example.springbootrao.service.UserInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

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
    private UserInfoMapper userInfoMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public String login(UserInfo userInfo, HttpServletRequest request) throws Exception {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.eq("account", userInfo.getAccount());
        UserInfo user = userInfoMapper.selectOne(wrapper);
        if (!MD5Utils.passwordVerity(userInfo.getPassword(), user.getPassword())) {
            Verify.notAcconutPassword();
        }
        String sessionId = (String) redisTemplate.opsForValue().get(userInfo.getAccount());
        //当用在同一个客户端重复登录时重新创建新的session
        if (sessionId != null) {
            if (sessionId.equals(request.getSession().getId())) {
                request.getSession().invalidate();
            }
            redisTemplate.opsForValue().set(sessionId, SysConstants.AUTO);
            redisTemplate.delete(userInfo.getAccount());
        }
        //将用户信息实例化Session中
        HttpSession session = request.getSession();
        session.setAttribute(SysConstants.USER_INFO, user);
        redisTemplate.opsForValue().set(userInfo.getAccount(), session.getId());
        return RetJson.makeOKRsp();
    }

    @Override
    public String logout(HttpServletRequest request) throws Exception {
        request.getSession().removeAttribute(SysConstants.USER_INFO);
        return RetJson.makeOKRsp();
    }

    @Override
    public String addRegister(UserInfo userInfo) throws Exception {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.eq("account", userInfo.getAccount());
        if (userInfoMapper.selectOne(wrapper) != null) {
            Verify.notUnique();
        }
        String md5 = MD5Utils.encrypt(userInfo.getPassword());
        userInfo.setPassword(md5);
        return userInfoMapper.insert(userInfo) > 0 ? RetJson.makeOKRsp() : RetJson.makeErrRsp();
    }

    @Override
    public void insertregister(UserInfo userInfo) throws Exception {
        userInfoMapper.insert(userInfo);
        int i = 1 / 0;

    }

}
