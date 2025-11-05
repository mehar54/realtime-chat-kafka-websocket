package com.chatapp.controller;
import com.chatapp.kafka.KafkaProducer;
import com.chatapp.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

@Component
public class ChatWebSocketHandler implements WebSocketHandler {

    private final KafkaProducer kafkaProducer;
    private final ObjectMapper mapper;

    public ChatWebSocketHandler(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Optional: log or track connection
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage textMessage) {
            ChatMessage chatMessage = mapper.readValue(textMessage.getPayload(), ChatMessage.class);
            kafkaProducer.sendMessage(chatMessage);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // Optional: log error or close session
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // Optional: cleanup
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}