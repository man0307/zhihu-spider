package com.mcy.infoboom.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/4 7:58 下午
 */
@Data
public class ResultModel<T> implements Serializable {
    /**
     * 用于序列化
     */
    private static final long serialVersionUID = -91231231434L;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 用户错误提示
     */
    private String tips;

    /**
     * 系统错误信息
     */
    private String errorMsg;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 数据
     */
    private T content;

    /**
     * @param data 结果数据
     * @param <T>  结果类型
     * @return 构造好的结果model
     */
    public static <T> ResultModel<T> success(T data) {
        ResultModel<T> result = new ResultModel<>();
        result.setSuccess(true);
        result.setContent(data);
        return result;
    }

    /**
     * @param msg       错误信息
     * @param errorCode 错误码
     * @param <T>       结果类型
     * @return 构造好的结果model
     */
    public static <T> ResultModel<T> failed(String msg, ErrorCode errorCode) {
        ResultModel<T> result = new ResultModel<>();
        result.setSuccess(false);
        result.setErrorCode(errorCode.getCode());
        result.setErrorMsg(msg);
        return result;
    }

    /**
     * @param msg 错误信息
     * @param <T> 结果类型
     * @return 构造好的结果model
     */
    public static <T> ResultModel<T> failed(String msg) {
        ResultModel<T> result = new ResultModel<>();
        result.setSuccess(false);
        result.setErrorMsg(msg);
        return result;
    }

}
