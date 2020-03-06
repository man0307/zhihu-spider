package com.mcy.infoboom.eventframework;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/14 11:40 下午
 */
public interface Dispatcher {

    /**
     * 事件分配器
     *
     * @param event 待处理的事件
     */
    <E extends Event> void dispatcher(E event);

}
