package com.mcy.zhihuspider.eventframework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/2/14 11:36 下午
 * <p>
 * 事件分配的入口 也是事件的统一分派器
 * 暂时先用内存的方式来实现事件的分派 后期可以考虑将事件的注入方式改为Redis的方式
 */
@Component
@Slf4j
public class NormalEventDispatcher implements Dispatcher {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<Class<? extends Event>, Handler<? extends Event>> handlerMap;


    @PostConstruct
    public void init() {
        //初始化容器中对应的Handler与其所关注事件类型的映射关系
        Map<String, Handler> eventHandlerMap = applicationContext.getBeansOfType(Handler.class);
        handlerMap = new HashMap<>(eventHandlerMap.size());
        eventHandlerMap.values().forEach(handler -> {
            //noinspection unchecked
            if (handlerMap.put(handler.getInterestedEventClass(), handler) != null) {
                throw new IllegalArgumentException("the event type already exist.");
            }
        });
    }

    @Override
    public <E extends Event> void dispatcher(E event) {
        if (Objects.isNull(event)) {
            throw new IllegalArgumentException("dispatcher error.event is null");
        }
        try {
            //noinspection unchecked
            Handler<E> handler = (Handler<E>) handlerMap.get(event.getEventType());
            if (Objects.isNull(handler)) {
                log.error("The handler corresponding to this event does not exist，event is {}", event.toString());
                throw new IllegalArgumentException("The handler corresponding to this event does not exist，event is {}");
            }
            handler.onEvent(event);
        } catch (Exception e) {
            log.error("dispatcher error.even={}", event.toString(), e);
            throw e;
        }
    }


}