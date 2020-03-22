package com.mcy.infoboom.exception;

import com.mcy.infoboom.enums.InfoBoomErrorCode;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/22 9:29 下午
 */
public class AtomicOperateException extends AbstractInfoBoomException {

    public AtomicOperateException(InfoBoomErrorCode infoBoomErrorCode) {
        super(infoBoomErrorCode);
    }
}
