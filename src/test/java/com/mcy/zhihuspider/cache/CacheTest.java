package com.mcy.zhihuspider.cache;

import com.mcy.zhihuspider.BaseTest;
import com.mcy.zhihuspider.service.TestService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/5 11:22 上午
 */
public class CacheTest extends BaseTest {

    @Resource
    private TestService testService;

    @Test
    public void testA(){
        System.out.println(testService.tttt(3));
        System.out.println(testService.tttt(3));
    }

}
