package com.mcy.zhihuspider.util;


import com.mcy.zhihuspider.util.fuctions.ProcessListFunction;
import org.springframework.util.CollectionUtils;

import java.util.List;

;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/1 6:07 下午
 * <p>
 * 分断处理列表的工具类
 */
public class SegmentedProcessingListUtils {

    /**
     * 分段处理长列表
     *
     * @param list                长列表
     * @param segmentSize         段大小
     * @param processListFunction 处理函数
     * @param <T>                 范型
     */
    public static <T> void segmentedProcessing(List<T> list, int segmentSize, ProcessListFunction<T> processListFunction) {
        if (CollectionUtils.isEmpty(list) || segmentSize < 1) {
            return;
        }
        int processNumber = (list.size() + segmentSize - 1) / segmentSize;
        for (int i = 0; i < processNumber; i++) {
            int begIndex = i * segmentSize;
            int endIndex = Math.min((i + 1) * segmentSize, list.size());
            processListFunction.processList(list.subList(begIndex, endIndex));
        }
    }

}
