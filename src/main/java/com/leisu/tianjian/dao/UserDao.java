package com.leisu.tianjian.dao;

import com.leisu.tianjian.model.UserModel;

public interface UserDao {
    UserModel getUserByName(String user);
}
