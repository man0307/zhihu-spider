package com.mcy.zhihuspider.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/5 11:07 上午
 */
public enum CacheEnum {
    TEST_TT(60 * 3L);
    /**
     * 缓存的过期时间
     */
    private Long ttl;

    CacheEnum(Long ttl) {
        this.ttl = ttl;
    }

    /**
     * 获取缓存key与TTL
     *
     * @return key与TTL的映射
     */
    public static Map<String, Long> getCacheKeyAndTtl() {
        return new ConcurrentHashMap<String, Long>(32) {{
            Arrays.stream(CacheEnum.values()).forEach(it -> put(it.name(), it.getTtl()));
        }};
    }

    public Long getTtl() {
        return ttl;
    }
}
