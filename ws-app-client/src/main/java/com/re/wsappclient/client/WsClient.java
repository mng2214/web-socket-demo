package com.re.wsappclient.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class WsClient implements CommandLineRunner {

    @Override
    public void run(String... args) {

        TextWebSocketHandler handler = new TextWebSocketHandler() {
            @Override
            public void afterConnectionEstablished(WebSocketSession session) throws IOException {
                System.out.println("Connection Established");
                session.sendMessage(new TextMessage("PING"));
            }

            @Override
            public void handleTextMessage(WebSocketSession session, TextMessage message) {
                System.out.println("Client received "+ message.getPayload());
            }

        };

        WebSocketConnectionManager webSocketConnectionManager = new WebSocketConnectionManager(
                new StandardWebSocketClient(),
                handler,
                "ws://localhost:1000/ws"
        );

        webSocketConnectionManager.start();
    }
}


