package com.qing.service;

import com.qing.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    User findByNameAndPwd(@Param("username") String username, @Param("password") String password);

    User findByName(String username);

    void addUser(User user);
}
