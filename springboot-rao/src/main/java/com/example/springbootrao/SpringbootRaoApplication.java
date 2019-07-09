package com.example.springbootrao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.example.springbootrao.mapper")
//@EnableScheduling//开始定时任务
@ServletComponentScan//扫描监听拦截器等(@WebServlet, @WebFilter, and @WebListener)
@EnableRedisHttpSession(redisNamespace = "mySession2")
public class SpringbootRaoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootRaoApplication.class, args);
    }

}
