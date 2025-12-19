package com.re.wsappserver.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class SimpleWsHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage msg) throws IOException {
        System.out.println("Server received a message: " + msg.getPayload());
        session.sendMessage(new TextMessage("PONG from server"));
    }
}
