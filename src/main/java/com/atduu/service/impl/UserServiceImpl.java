package com.atduu.service.impl;

import com.atduu.mapper.UserMapper;
import com.atduu.pojo.User;
import com.atduu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {

        return userMapper.findByUsernameAndPassword(username, password);

    }
}
