package com.mcy.infoboom.web.csrf;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/5/7 11:21 下午
 */
public class TokenValidInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //todo 待实现拦截器
        return true;
    }
}
