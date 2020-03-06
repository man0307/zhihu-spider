package com.mcy.infoboom.util.fuctions;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/2 4:21 下午
 * <p>
 * 对象转化函数接口
 */
public interface ProcessConvertFunction<T, D> {

    /**
     * 转化接口
     *
     * @param item 对象
     * @return 转化后的对象
     */
    D convert(T item);

}
