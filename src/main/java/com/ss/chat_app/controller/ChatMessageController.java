package com.ss.chat_app.controller;
import com.ss.chat_app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {

    // Handles messages sent to "/app/sendMessage"
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("chat message in controller "+message.getContent() +message.getFrom());
        // For now, just echo the message back to all subscribers
        return new ChatMessage(message.getFrom(), message.getContent());
    }
}
