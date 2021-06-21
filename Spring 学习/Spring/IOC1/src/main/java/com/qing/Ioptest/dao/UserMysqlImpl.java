package com.qing.Ioptest.dao;

public class UserMysqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("获取Mysql数据");
    }
}
