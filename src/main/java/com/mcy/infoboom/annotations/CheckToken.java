package com.mcy.infoboom.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/5/7 11:13 下午
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface CheckToken {

    /**
     * 是否检测重复提交
     *
     * @return 是否重复提交
     */
    boolean checkRepeat() default true;

}
