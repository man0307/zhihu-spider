package com.mcy.infoboom.eventframework;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/14 11:15 下午
 */
public interface Event{

    /**
     * 获取事件类的类型
     *
     * @return 事件类的Class对象
     */
    Class<? extends Event> getEventType();

}
