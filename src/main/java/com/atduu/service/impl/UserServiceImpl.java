package com.atduu.service.impl;

import com.atduu.dao.UserDao;
import com.atduu.pojo.User;
import com.atduu.service.UserService;
import com.atduu.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserDao userDao;

    @Override
    public User checkUser(String username, String password) {

        return userDao.findByUsernameAndPassword(username, MD5Util.code(password));

    }
}
