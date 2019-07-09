package com.example.springbootrao.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author guoyou
 * @date 2019/7/9 10:45
 */
@Configuration
public class RouterInterceptor implements WebMvcConfigurer {
    @Bean
    public ExecuteInterceptor getExecuteInterceptor() {
        return new ExecuteInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getExecuteInterceptor())
                .excludePathPatterns("/userInfo/login")
                .addPathPatterns("/**");
    }

}
