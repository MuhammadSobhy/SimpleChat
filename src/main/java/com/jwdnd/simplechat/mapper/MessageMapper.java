package com.jwdnd.simplechat.mapper;

import com.jwdnd.simplechat.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("select * from messages")
    public List<ChatMessage> getUserMessages();

    @Insert("Insert Into messages (userName , messageText)" +
            "values (#{userName},#{messageText})")
    @Options(useGeneratedKeys = true,keyProperty = "messageId")
    public int addMessage(ChatMessage chatMessage);
}
