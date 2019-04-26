package com.leisu.tianjian.service.Impl;

import com.leisu.tianjian.dao.UserDao;
import com.leisu.tianjian.model.UserModel;
import com.leisu.tianjian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserModel getUserByName(String user) {
        return userDao.getUserByName(user);
    }

    @Autowired
    private UserDao userDao;
}
