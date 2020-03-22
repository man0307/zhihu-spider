package com.mcy.infoboom.web.aop;

import com.mcy.infoboom.domain.ResultModel;
import com.mcy.infoboom.exception.AbstractInfoBoomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/22 9:22 下午
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAopHandler {

    @ExceptionHandler(value = AbstractInfoBoomException.class)
    public ResultModel<Void> resolveAbstractInfoBoomException(AbstractInfoBoomException ex) {
        ResultModel<Void> resultModel = new ResultModel<>();
        resultModel.setTips("系统异常，请稍后重试");
        return resultModel;
    }

}
