package com.mcy.infoboom.util.fuctions;

import java.util.List;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/1 6:03 下午
 */
public interface ProcessListFunction<T> {

    /**
     * 对列表进行处理的函数式接口
     *
     * @param list 列表
     */
    void processList(List<T> list);

}
