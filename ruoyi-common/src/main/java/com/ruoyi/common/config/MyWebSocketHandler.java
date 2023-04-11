package com.ruoyi.common.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class MyWebSocketHandler implements WebSocketHandler {

    // 在线数量
    private static Integer count = 0;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("1");
        count++;
        System.out.println(count);
        // 连接建立后处理逻辑
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("2");
        // 处理收到的消息
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("3");
        // 处理传输错误
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("4");
        count--;
        System.out.println(count);
        // 连接关闭后处理逻辑
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
