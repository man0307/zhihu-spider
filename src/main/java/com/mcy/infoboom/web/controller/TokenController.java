package com.mcy.infoboom.web.controller;

import com.mcy.infoboom.util.token.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/5/7 10:17 下午
 */
@RestController
@Api(tags = {"token的获取接口"})
@RequestMapping("/token")
@Slf4j
public class TokenController {

    @Resource
    private TokenUtils tokenUtils;

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    @ApiOperation("获取token")
    public String getToken() {
        return tokenUtils.getToken();
    }

}
