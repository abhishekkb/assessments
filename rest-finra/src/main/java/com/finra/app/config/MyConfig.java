package com.finra.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.finra.restapi.interceptors.FinraInterceptor;

// for the purpose troubleshooting and monitor the incoming requests

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new FinraInterceptor()).addPathPatterns("/**");
    }
}
