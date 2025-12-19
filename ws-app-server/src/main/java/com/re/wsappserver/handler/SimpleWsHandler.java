package com.re.wsappserver.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class SimpleWsHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage msg) throws IOException {
        System.out.println("Server received a message: " + msg.getPayload());

        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    if (!session.isOpen()) return;
                    TextMessage textMessage = new TextMessage("PONG " + i);

                    session.sendMessage(textMessage);
                    System.out.println("Server sent: %s".formatted(textMessage.getPayload()) );
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
