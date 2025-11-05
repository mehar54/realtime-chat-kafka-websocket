package com.chatapp.kafka;

import com.chatapp.model.ChatMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, ChatMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ChatMessage message) {
        CompletableFuture<SendResult<String, ChatMessage>> future =
                kafkaTemplate.send("chat-messages", message.getRoomId(), message);

        future.thenAccept(result ->
                logger.info("Message sent successfully: {}", message)
        ).exceptionally(ex -> {
            logger.error("Failed to send message: {}", message, ex);
            return null;
        });
    }
}