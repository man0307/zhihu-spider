package com.mcy.infoboom.cache;

import com.mcy.infoboom.BaseTest;
import com.mcy.infoboom.util.lock.RedisLock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/8/20 9:22 下午
 */
public class RedisLockTest extends BaseTest {

    private static final String REDIS_LOCK_KEY = "testLockKey";

    private static final String REDIS_LOCK_VALUE = "testLockValue";

    @Autowired
    private RedisLock redisLock;

    @Test
    public void testRedisLock() {
        try {
            Boolean lockResult = redisLock.getLock(REDIS_LOCK_KEY, REDIS_LOCK_VALUE, 1000);
            Assert.assertTrue(lockResult);
            Boolean lockResult1 = redisLock.getLock(REDIS_LOCK_KEY, REDIS_LOCK_VALUE, 1000);
            Assert.assertFalse(lockResult1);
            Thread.sleep(1000);
            Boolean lockResult2 = redisLock.getLock(REDIS_LOCK_KEY, REDIS_LOCK_VALUE, 1000);
            Assert.assertTrue(lockResult2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            redisLock.releaseLock(REDIS_LOCK_KEY, REDIS_LOCK_VALUE);
        }


    }

}
