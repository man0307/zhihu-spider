package com.mcy.zhihuspider.eventframework;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/14 11:28 下午
 */
public interface Handler<T extends Event> {

    /**
     * 处理事件的流程接口
     *
     * @param event 事件
     */
    void onEvent(T event);

    /**
     * 获取所关注的事件类的对象
     *
     * @return 该handler所关注的事件类的对象
     */
    Class<? extends Event> getInterestedEventClass();

}
