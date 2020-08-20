package com.mcy.infoboom.config;

import com.mcy.infoboom.web.csrf.TokenValidInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/8/20 10:30 下午
 */
@Configuration
public class FilterConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private TokenValidInterceptor tokenValidInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenValidInterceptor);
     }
}
