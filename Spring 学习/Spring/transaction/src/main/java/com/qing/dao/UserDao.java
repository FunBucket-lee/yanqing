package com.qing.dao;

import com.qing.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> selectUser();

    int addUser(User user);

    int deleteUser(int id);
}
