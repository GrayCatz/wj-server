package com.wj.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private PassportInterceptor userAuthInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
//        addPathPatterns添加需要拦截的命名空间；
//        excludePathPatterns添加排除拦截命名空间
        registry.addInterceptor(userAuthInterceptor).addPathPatterns("/**").excludePathPatterns("/api/v1/token/add");
    }

}