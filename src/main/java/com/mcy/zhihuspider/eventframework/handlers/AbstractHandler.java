package com.mcy.zhihuspider.eventframework.handlers;

import com.mcy.zhihuspider.eventframework.Event;
import com.mcy.zhihuspider.eventframework.Handler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/15 6:54 下午
 */
@Slf4j
public abstract class AbstractHandler<T extends Event> implements Handler<T> {
    /**
     * 处理事件的流程接口
     *
     * @param event 事件
     */
    @Override
    public void onEvent(T event) {
        if (!validateEventParams(event)) {
            log.error("onEvent error:event params is error.event={}", event.toString());
            throw new IllegalArgumentException("onEvent error:event params is error.");
        }
        processEvent(event);
    }

    /**
     * 校验事件类型参数是否符合要求
     *
     * @param event 事件
     * @return 是否合格
     */
    protected abstract boolean validateEventParams(T event);

    /**
     * 事件处理函数
     *
     * @param event 事件
     */
    protected abstract void processEvent(T event);



}
