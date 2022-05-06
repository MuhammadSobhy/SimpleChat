package com.jwdnd.simplechat.service;

import com.jwdnd.simplechat.mapper.MessageMapper;
import com.jwdnd.simplechat.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    MessageMapper messageMapper;

    public ChatService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public void addMessage (ChatMessage messageModel) {
        messageMapper.addMessage(messageModel);
    }

    public List<ChatMessage> getMessages () {
        return messageMapper.getUserMessages();
    }
}
