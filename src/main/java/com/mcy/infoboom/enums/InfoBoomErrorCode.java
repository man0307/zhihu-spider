package com.mcy.infoboom.enums;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/22 9:01 下午
 * 项目的所有异常码枚举
 * 所有异常分为系统异常(SYS开头)与业务异常(BIZ开头)
 */
public enum InfoBoomErrorCode {

    /**
     * 数据库查询异常
     */
    DATABASE_QUERY_ERROR("SYS_DB_Q_001", "系统异常:数据库查询异常"),

    ;

    /**
     * 错误码（分类型分场景，可以按图索骥）
     */
    private String code;

    /**
     * 描述
     */
    private String desc;


    InfoBoomErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
