package com.mcy.infoboom.util;

import com.mcy.infoboom.util.fuctions.ProcessConvertFunction;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/2 4:25 下午
 * <p>
 * 列表转化的工具
 */
public class ListConvertUtil {

    /**
     * @param list            待转化列表
     * @param convertFunction 转化函数
     * @param <T>             原有类型
     * @param <D>             转化类型
     * @return 转化后列表
     */
    public static <T, D> List<D> convertListByFunction(List<T> list, ProcessConvertFunction<T, D> convertFunction) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(convertFunction::convert).collect(Collectors.toList());
    }
}
