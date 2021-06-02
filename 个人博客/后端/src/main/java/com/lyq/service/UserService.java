package com.lyq.service;

import com.lyq.po.User;

public interface UserService {

    User checkUser(String username , String password);
}
