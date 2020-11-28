package com.mcy.infoboom.study;

import com.mcy.infoboom.BaseTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/10/24 7:42 下午
 */
public class MySQLStudyTest extends BaseTest {

    @Resource
    private MySQLStudy mySQLStudy;

    @Test
    public void testDirtyRead() throws InterruptedException {
        new Thread(()->{
            try {
                mySQLStudy.updateDelay();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        mySQLStudy.dirtyRead();
        while (true){

        }
    }

}
