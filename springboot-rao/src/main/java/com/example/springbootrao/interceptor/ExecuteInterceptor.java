package com.example.springbootrao.interceptor;

import com.alibaba.druid.util.StringUtils;
import com.example.springbootrao.common.constant.SysConstants;
import com.example.springbootrao.common.model.UserInfo;
import com.example.springbootrao.common.ret.RetCode;
import com.example.springbootrao.common.ret.RetJson;
import org.apache.catalina.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author guoyou
 * @date 2019/7/9 10:53
 */
@Component
public class ExecuteInterceptor implements HandlerInterceptor {
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String outoStr = (String) redisTemplate.opsForValue().get(session.getId());

        if (!StringUtils.isEmpty(outoStr)) {
            session.invalidate();
            byte[] bytes = RetJson.makeRsp(RetCode.UNAUTHORIZED, "用户未登录").getBytes("UTF-8");
            ServletOutputStream outputStream = response.getOutputStream();
            response.setHeader("content-type", "application/json;charset=UTF-8");
            outputStream.write(bytes);
            return false;
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(SysConstants.USER_INFO);
        if (userInfo == null) {

            byte[] bytes = RetJson.makeRsp(RetCode.UNAUTHORIZED, "用户未登录").getBytes("UTF-8");
            ServletOutputStream outputStream = response.getOutputStream();
            response.setHeader("content-type", "application/json;charset=UTF-8");
            outputStream.write(bytes);
            return false;
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
