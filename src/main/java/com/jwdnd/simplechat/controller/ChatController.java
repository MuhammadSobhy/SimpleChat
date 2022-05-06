package com.jwdnd.simplechat.controller;

import com.jwdnd.simplechat.model.ChatForm;
import com.jwdnd.simplechat.model.ChatMessage;
import com.jwdnd.simplechat.service.ChatService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public String addMessage(ChatForm chatForm , Model model , Authentication authentication) {
        ChatMessage messageModel = new ChatMessage();
        messageModel.setUserName(authentication.getName());
        messageModel.setMessageText(applyMessageMode(chatForm.getMessage() , chatForm.getMode()));
        chatService.addMessage(messageModel);
        model.addAttribute("messages" , chatService.getMessages());
        return "chat";
    }

    @GetMapping
    public String getMessages(ChatForm chatForm , Model model) {
        model.addAttribute("messages" , chatService.getMessages());
        return "chat";
    }

    private String applyMessageMode(String message , String mode) {
        String messageWithMode = message;
        switch (mode) {
            case "shout" :
                messageWithMode = message.toUpperCase();
                break;
            case "whisper":
                messageWithMode = message.toLowerCase();
                break;
        }
        return messageWithMode;
    }
}
