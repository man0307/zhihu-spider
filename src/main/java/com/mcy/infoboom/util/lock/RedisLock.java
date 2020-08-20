package com.mcy.infoboom.util.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/4/12 4:57 下午
 * <p>
 * 使用redis做一个分布式锁
 */
@Service
@Slf4j
public class RedisLock {


    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 获取分布式锁
     *
     * @param lockKey 锁键
     * @param value   值
     * @param delay   延迟 防止死锁(必填字段)
     * @return 是否获取锁成功
     */
    public Boolean getLock(String lockKey, String value, long delay) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(value)) {
            return false;
        }

        try {
            return redisTemplate.opsForValue().setIfAbsent(lockKey, value, Duration.ofMillis(delay));
        } catch (Exception e) {
            log.error("RedisLock-getLock error.lockKey={},value={},delay={}", lockKey, value, delay);
        }
        return false;
    }

    /**
     * 释放分布式锁
     *
     * @param lockKey 锁键
     * @param value   值
     * @return 是否释放锁成功
     */
    public Boolean releaseLock(String lockKey, String value) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(value)) {
            return false;
        }

        String currentValue = redisTemplate.opsForValue().get(lockKey);
        if (StringUtils.equals(value, currentValue)) {
            try {
                redisTemplate.opsForValue().getOperations().delete(lockKey);
            } catch (Exception e) {
                log.error("RedisLock-releaseLock error.lockKey={},value={}", lockKey, value);
                throw e;
            }
        }
        return false;
    }

}
