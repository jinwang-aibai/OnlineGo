package com.ruoyi.webSocket;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Step;
import com.ruoyi.system.service.ISysUserService;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WebSocketGo implements WebSocketHandler {

    @Autowired
    private ISysUserService userService;

    private static Map<Long, List<SysUser>> map = new HashMap<>();

    private static Map<Long, Step> mapStep = new HashMap<>();

    private static Map<Long, Boolean> mapFlag = new HashMap<>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocket连接成功");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = message.getPayload().toString();
        JSONObject jsonObject = JSONObject.parseObject(json);
        Byte type = jsonObject.getByte("type");
        Long roomId = jsonObject.getLong("roomId");

        if (type == 1) {
            Step step = mapStep.get(roomId);
            if (step == null) {
                step = new Step();
            }
            Long x = jsonObject.getLong("x");
            Long y = jsonObject.getLong("y");
            step.setHang(x);
            step.setLie(y);
            mapStep.put(roomId, step);
            return;
        }else if (type == 2) {
//            Long roomId = jsonObject.getLong("roomId");
            List<SysUser> userList = map.get(roomId);
            if(userList.size() != 2 || !jsonObject.getBoolean("openGameFlag")){
                JSONObject object = new JSONObject();
                object.put("type", 2);
                object.put("list", objectMapper.writeValueAsString(map));
                object.put("openGameFlag", jsonObject.getBoolean("openGameFlag"));
                object.put("flag", mapFlag.get(roomId) != null && mapFlag.get(roomId));
                session.sendMessage(new TextMessage(object.toJSONString()));
                return;
            }
            Step step = mapStep.get(roomId);
            if (step == null) {
                step = new Step();
            }
            JSONObject object = step.toJSONObject();
            object.put("type", 1);
            object.put("list", objectMapper.writeValueAsString(map));
            object.put("flag", mapFlag.get(roomId) != null && mapFlag.get(roomId));
            session.sendMessage(new TextMessage(object.toJSONString()));
            return;
        }else if (type == 3){
            mapFlag.put(roomId, true);
            return;
        }

        Long userId = jsonObject.getLong("userId");
        List<SysUser> userList = map.get(roomId);
        if (userList == null) {
            userList = Lists.newArrayList();
        }
        userList.add(userService.selectUserById(userId));
        map.put(roomId, userList);
        session.getAttributes().put("userId", userId);
        session.getAttributes().put("roomId", roomId);
        session.sendMessage(new TextMessage(objectMapper.writeValueAsString(map)));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("*************3");
        // 处理传输错误
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        Long userId = (Long)session.getAttributes().get("userId");
        Long roomId = (Long)session.getAttributes().get("roomId");
        List<SysUser> userList = map.get(roomId);
        for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getUserId().equals(userId) ) {
                userList.remove(i);
                break;
            }
        }
        map.put(roomId, userList);
        // 连接关闭后处理逻辑
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
