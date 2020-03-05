package com.mcy.zhihuspider.domain;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/28 4:46 下午
 */
public interface ErrorCode {

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMessage();

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    String getCode();
}
