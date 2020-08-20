package com.mcy.infoboom.web.csrf;

import com.mcy.infoboom.annotations.CheckToken;
import com.mcy.infoboom.util.token.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/5/7 11:21 下午
 * <p>
 * 用于校验打了CSRF注解的Rest接口
 */
@Component
public class TokenValidInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            CheckToken checkToken = ((HandlerMethod) handler).getMethodAnnotation(CheckToken.class);
            if (Objects.isNull(checkToken)) {
                return true;
            }

            //需要进行csrf验证
            if (checkToken.checkRepeat()) {
                return tokenUtils.invalidateToken(request.getParameter("_request_token"));
            }
        }
        return true;
    }
}
