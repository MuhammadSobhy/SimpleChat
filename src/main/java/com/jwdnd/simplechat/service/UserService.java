package com.jwdnd.simplechat.service;

import com.jwdnd.simplechat.mapper.UserMapper;
import com.jwdnd.simplechat.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    HashService hashService;
    UserMapper userMapper;

    public UserService(HashService hashService, UserMapper userMapper) {
        this.hashService = hashService;
        this.userMapper = userMapper;
    }

    public int createUser(User user) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword() , encodedSalt);
        return userMapper.addUser(new User(user.getUserName(),hashedPassword , encodedSalt,
                user.getFirstName(),user.getLastName()));
    }
}
