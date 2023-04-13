package com.ruoyi.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class WebSocketEndpoint implements WebSocketHandler {

    @Autowired
    private ISysUserService userService;

    // 在线数量
    private static Integer count = 0;
    private static Map<Long, SysUser> map = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String json = message.getPayload().toString();
        JSONObject jsonObject = JSONObject.parseObject(json);
        Byte type = jsonObject.getByte("type");
        if (type == 0) {
            count++;
            Long userId = jsonObject.getLong("userId");
            map.put(userId, userService.selectUserById(userId));
            session.getAttributes().put("userId", userId);
            // 处理收到的消息
        }else if (type == 1) {
            ObjectMapper objectMapper = new ObjectMapper();
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(map)));
        }
        session.getAttributes().put("type", type);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // 处理传输错误
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        Byte type = (Byte)session.getAttributes().get("type");
        if (type == 0) {
            count--;
            Long userId = (Long)session.getAttributes().get("userId");
            map.remove(userId);
        }
        // 连接关闭后处理逻辑
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
