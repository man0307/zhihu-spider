package com.mcy.infoboom.eventframework.events;


import com.mcy.infoboom.eventframework.Event;

import java.io.Serializable;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/14 11:17 下午
 * <p>
 * 事件的抽象类
 */
public abstract class AbstractEvent implements Event, Serializable {

    private static final long serialVersionUID = 123456789L;

    @Override
    public Class<? extends Event> getEventType() {
        return this.getClass();
    }

}
