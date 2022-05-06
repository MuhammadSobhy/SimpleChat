package com.jwdnd.simplechat.mapper;

import com.jwdnd.simplechat.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from users where userName = #{userName}")
    public User getUser(String userName);

    @Insert("insert into users (userName,salt,password,firstName,lastName)" +
            "values (#{userName},#{salt},#{password},#{firstName},#{lastName})")
    @Options(useGeneratedKeys = true,keyProperty = "userId")
    public int addUser(User user);
}
