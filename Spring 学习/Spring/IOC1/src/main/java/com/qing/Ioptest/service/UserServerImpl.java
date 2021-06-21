package com.qing.Ioptest.service;

import com.qing.Ioptest.dao.UserDao;
import com.qing.Ioptest.dao.UserDaoImpl;
import com.qing.Ioptest.dao.UserMysqlImpl;
import com.qing.Ioptest.dao.UserOracleImpl;

public class UserServerImpl implements UserServer{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
