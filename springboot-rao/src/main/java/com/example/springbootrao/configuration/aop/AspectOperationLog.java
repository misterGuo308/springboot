package com.example.springbootrao.configuration.aop;
import com.example.springbootrao.common.constant.SysConstants;
import com.example.springbootrao.common.model.SysLog;
import com.example.springbootrao.common.model.UserInfo;
import com.example.springbootrao.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

import com.example.springbootrao.common.annotation.AspectLog;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 系统操作日志
 */
@Component
@Aspect
public class AspectOperationLog {

    @Resource
    private SysLogService sysLogService;


    /**
     * 环绕通知
     */
    @Around("@annotation(com.example.springbootrao.common.annotation.AspectLog)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {


        //获取签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取方法
        Method method = signature.getMethod();
        AspectLog annotation = method.getAnnotation(AspectLog.class);
        String operation = annotation.operation();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        String ip = request.getRemoteAddr();
        UserInfo userInfo = (UserInfo) session.getAttribute(SysConstants.USER_INFO);
        SysLog sysLog = new SysLog();
        sysLog.setDateTime(LocalDateTime.now());
        sysLog.setOperation(operation);
        sysLog.setMethodName(method.getName());
        sysLog.setUserId(userInfo.getId());
        sysLog.setUserName(userInfo.getName());
        sysLog.setIp(ip);
        Object result = null;
        try {
            result = joinPoint.proceed();
            sysLog.setComment("操作成功");
        } catch (Throwable e) {
            sysLog.setComment("操作失败");
            throw new Throwable();
        } finally {
            sysLogService.save(sysLog);
        }
        return result;
    }


}
