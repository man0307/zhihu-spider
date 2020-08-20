package com.mcy.infoboom.util.token;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Objects;
import java.util.UUID;

import static com.mcy.infoboom.constants.WebConstants.*;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/5/7 10:35 下午
 */
@Service
@Slf4j
public class TokenUtils {

    /**
     * token的前缀
     */
    private static final String TOKEN_PRE = "token:";


    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 获取Redis中对应的key
     *
     * @param token token
     * @return token对应的key
     */
    public String getTokenKey(String token) {
        if (StringUtils.isBlank(token)) {
            return token;
        }
        redisTemplate.opsForValue().set(getTokenKey(token), TOKEN_VALID_VALUE, Duration.ofDays(TOKEN_TTL_DAYS));
        return TOKEN_PRE + token;
    }


    public boolean invalidateToken(String token) {
        if (StringUtils.isBlank(token)) {
            return false;
        }

        //token不存在则说明过期/无效
        if (Objects.isNull(redisTemplate.opsForValue().get(getTokenKey(token)))) {
            return false;
        }

        String value = (String) redisTemplate.opsForValue().get(getTokenKey(token));
        //已经过期
        if (StringUtils.equals(TOKEN_EXPIRED_VALUE, value)) {
            return false;
        }

        redisTemplate.opsForValue().set(getTokenKey(token), TOKEN_EXPIRED_VALUE, Duration.ofDays(TOKEN_TTL_DAYS));
        return true;
    }


    /**
     * 获取token
     *
     * @return token
     */
    public String getToken() {
        String token = UUID.randomUUID().toString();
        buildToken(token);
        return token;
    }

    /**
     * 在Redis中加入token
     *
     * @param token 随机token串
     */
    private void buildToken(String token) {
        String key = TOKEN_PRE + token;
        redisTemplate.opsForValue().set(getTokenKey(key), TOKEN_VALID_VALUE, Duration.ofMillis(TOKEN_TTL_DAYS));
    }

}
