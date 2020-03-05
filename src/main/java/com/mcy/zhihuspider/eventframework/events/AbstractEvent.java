package com.mcy.zhihuspider.eventframework.events;


import com.mcy.zhihuspider.eventframework.Event;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/14 11:17 下午
 * <p>
 * 实现事件的抽象类
 */
public abstract class AbstractEvent implements Event {

    @Override
    public Class<? extends Event> getEventType() {
        return this.getClass();
    }

}
