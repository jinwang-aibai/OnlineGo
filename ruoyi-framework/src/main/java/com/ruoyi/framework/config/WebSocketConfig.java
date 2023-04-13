package com.ruoyi.framework.config;

import com.ruoyi.webSocket.WebSocketEndpoint;
import com.ruoyi.webSocket.WebSocketGo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private WebSocketEndpoint webSocketEndpoint;
    @Autowired
    private WebSocketGo webSocketGo;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketEndpoint, "/webSocketEndpoint").setAllowedOrigins("*");
        registry.addHandler(webSocketGo, "/webSocketGo").setAllowedOrigins("*");
    }
}
