package com.mcy.infoboom.eventframework.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/4/27 11:46 下午
 */
public class Test {

    public static void main(String...args) {
        // 定义一个EventBus对象，这里的Joker是该对象的id
        EventBus eventBus = new EventBus("Joker");
        // 向上述EventBus对象中注册一个监听对象
        eventBus.register(new EventListener1());
        // 使用EventBus发布一个事件，该事件会给通知到所有注册的监听者
        eventBus.post(new Event("Hello every listener, joke begins..."));
        eventBus.post(new Event1("Hello every listener, joke begins..."));
    }

    // 事件，监听者监听的事件的包装对象
    public static class Event {
        public String message;
        Event(String message) {
            this.message = message;
        }
    }

    // 事件，监听者监听的事件的包装对象
    public static class Event1 {
        public String message;
        Event1(String message) {
            this.message = message;
        }
    }

    // 监听者
    public static abstract class EventListener {
        // 监听的方法，必须使用注解声明，且只能有一个参数，实际触发一个事件的时候会根据参数类型触发方法
        @Subscribe
        public abstract void listen1(Event1 event);
        @Subscribe
        public abstract void listen(Event event);
    }

    public static class EventListener1 extends  EventListener{


        // 监听的方法，必须使用注解声明，且只能有一个参数，实际触发一个事件的时候会根据参数类型触发方法
        @Override
        @Subscribe
        public void listen1(Event1 event) {
            System.out.println("eeeee " + event.message);
        }

        @Override
        @Subscribe
        public void listen(Event event) {
            System.out.println(event.message);
        }
    }



}
