package com.mcy.infoboom.cache;

import com.mcy.infoboom.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/7/5 12:08 上午
 */
public class RedisConnectionTest extends BaseTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testConnection() {
        redisTemplate.opsForValue().set("mcy", "value");
    }

}
