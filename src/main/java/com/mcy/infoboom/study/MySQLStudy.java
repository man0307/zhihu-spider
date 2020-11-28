package com.mcy.infoboom.study;

import com.alibaba.fastjson.JSON;
import com.mcy.infoboom.dao.TestDataMapper;
import com.mcy.infoboom.domain.TestData;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/10/24 7:21 下午
 */
@Component
public class MySQLStudy {

    @Resource
    private TestDataMapper testDataMapper;

    /**
     * 复现脏读
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void dirtyRead() {
        try {
            //睡眠1分钟
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("一次事务开始------------------------------------------------------------------------");
        TestData testData = testDataMapper.selectByPrimaryKey(1L);
        System.out.println("查询到的数据:" + JSON.toJSONString(testData));
        System.out.println("一次事务结束------------------------------------------------------------------------");
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED, rollbackFor = Exception.class)
    public void updateDelay() throws InterruptedException {
        System.out.println("一次事务开始------------------------------------------------------------------------");
        TestData testData = testDataMapper.selectByPrimaryKey(1L);
        Random random = new Random();
        testData.setName("设置一个随机数" + random.nextInt(100000));
        testDataMapper.updateByPrimaryKey(testData);
        System.out.println("设置随机数但事务没有提交前" + JSON.toJSONString(testData));
        try {
            //睡眠1分钟
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new InterruptedException();
//            System.out.println("一次事务结束------------------------------------------------------------------------:"+testData.getName());
    }

}
