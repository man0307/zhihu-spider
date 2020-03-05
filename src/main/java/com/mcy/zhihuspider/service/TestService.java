package com.mcy.zhihuspider.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/5 11:47 上午
 */
@Component
public class TestService {

    @Cacheable(cacheNames = "TEST_TT")
    public int tttt(int i) {
        return new Random().nextInt();
    }

}
