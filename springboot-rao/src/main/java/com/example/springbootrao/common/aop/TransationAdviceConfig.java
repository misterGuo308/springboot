package com.example.springbootrao.common.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.Resource;

@Aspect
@Configuration
public class TransationAdviceConfig {

    //excution表达式

    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.example.demo.service.*.*(..))";

    @Resource
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {

        DefaultTransactionAttribute TX_ATTR_REQUIRED = new DefaultTransactionAttribute();
        ////设置事务的传播行为 PROPAGATION_REQUIRED支持当前事务
        TX_ATTR_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_MANDATORY);

        TX_ATTR_REQUIRED.rollbackOn(new Throwable());
        //使用默认的事务隔离级别 防止脏读保证一个事务修改的数据提交后才能被另外一个事务读取。
        TX_ATTR_REQUIRED.setPropagationBehavior(TransactionDefinition.ISOLATION_READ_COMMITTED);

        DefaultTransactionAttribute TX_ATTR_REQUIRED_READONLY = new DefaultTransactionAttribute();

        TX_ATTR_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_MANDATORY);

        TX_ATTR_REQUIRED_READONLY.setReadOnly(true);
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("add*", TX_ATTR_REQUIRED);
        source.addTransactionalMethod("save*", TX_ATTR_REQUIRED);
        source.addTransactionalMethod("insert*", TX_ATTR_REQUIRED);
        source.addTransactionalMethod("delete*", TX_ATTR_REQUIRED);
        source.addTransactionalMethod("update*", TX_ATTR_REQUIRED);
        source.addTransactionalMethod("exec*", TX_ATTR_REQUIRED);
        source.addTransactionalMethod("get*", TX_ATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("query*", TX_ATTR_REQUIRED_READONLY);

        source.addTransactionalMethod("find*", TX_ATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("list*", TX_ATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("count*", TX_ATTR_REQUIRED_READONLY);
        source.addTransactionalMethod("is*", TX_ATTR_REQUIRED_READONLY);
        //返回事务拦截器
        return new TransactionInterceptor(transactionManager, source);


    }
    @Bean
    public Advisor txAdviceAdvisor(){
        //aspecctj的节点表达式
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        //返回通知器
        return  new DefaultPointcutAdvisor(pointcut,txAdvice());


    }


}
