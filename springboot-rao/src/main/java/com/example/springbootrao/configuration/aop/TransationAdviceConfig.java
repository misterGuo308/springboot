package com.example.springbootrao.configuration.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.Resource;

@Aspect
@Configuration
public class TransationAdviceConfig {

    //(..)代表该包下的任意方法 com.baomidou.mybatisplus.extension.service
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.example.springbootrao.service.*.*(..)) or execution(* com.baomidou.mybatisplus.extension.service.*.*(..))";
    //注入事务管理平台
    @Resource
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {
        //创建默认的事务属性
        DefaultTransactionAttribute TXATTR_REQUIRED = new DefaultTransactionAttribute();
        //设置事务的传播行为 PROPAGATION_REQUIRED支持当前事务，如果当前没有事务，就新建一个事务。这是最常见的选择。
        TXATTR_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //发生异常就进行回滚
        TXATTR_REQUIRED.rollbackOn(new Throwable());
        //使用默认的事务隔离级别 防止脏读保证一个事务修改的数据提交后才能被另外一个事务读取。
        TXATTR_REQUIRED.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);


        DefaultTransactionAttribute TXATTR_REQUIRED_READONLY = new DefaultTransactionAttribute();
        TXATTR_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TXATTR_REQUIRED_READONLY.setReadOnly(true);
        //名称匹配事务源
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("add*", TXATTR_REQUIRED);
        source.addTransactionalMethod("save*", TXATTR_REQUIRED);
        source.addTransactionalMethod("insert*", TXATTR_REQUIRED);
        source.addTransactionalMethod("delete*", TXATTR_REQUIRED);
        source.addTransactionalMethod("update*", TXATTR_REQUIRED);
        source.addTransactionalMethod("exec*", TXATTR_REQUIRED);
        source.addTransactionalMethod("get*", TXATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("query*", TXATTR_REQUIRED_READONLY);

        source.addTransactionalMethod("find*", TXATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("list*", TXATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("count*", TXATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("is*", TXATTR_REQUIRED_READONLY);
        //返回事务拦截器
        return new TransactionInterceptor(transactionManager, source);
    }


    @Bean
    public Advisor txAdviceAdvisor() {
        //aspectj的切点表达式
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        //返回通知器
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}



