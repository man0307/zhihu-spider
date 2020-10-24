package com.mcy.infoboom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;


/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/9/3 11:23 下午
 * <p>
 * 实现WebSocket的配置(Stomp)
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {


    /**
     * 设置消息的最大长度为10M
     */
    private static final int MAX_MESSAGE_BODY = 1024 * 1024 * 10;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个stomp端点
        registry.addEndpoint("/ws").setAllowedOrigins("*");
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        //设置消息的最大体积
        registry.setMessageSizeLimit(MAX_MESSAGE_BODY);
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("topic");
    }


}
