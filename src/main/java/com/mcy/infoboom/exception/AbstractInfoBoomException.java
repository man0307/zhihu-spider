package com.mcy.infoboom.exception;

import com.mcy.infoboom.enums.InfoBoomErrorCode;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/22 8:54 下午
 * <p>
 * 所有的自定义异常都要实现这个异常类（便于Controller进行统一异常处理）
 */
public abstract class AbstractInfoBoomException extends Exception {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    abstract InfoBoomErrorCode getErrorCode();

}
