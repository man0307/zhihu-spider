package com.mcy.infoboom.cache;

import com.mcy.infoboom.BaseTest;
import com.mcy.infoboom.dao.TestDataMapper;
import com.mcy.infoboom.domain.TestData;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/10/24 4:20 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DBStudyTest extends BaseTest {

    @Resource
    private TestDataMapper testDataMapper;

    @Test
    public void testInsert(){
        TestData testData = new TestData();
        testData.setName("test_1");
        testDataMapper.insert(testData);
    }
}
