package com.qing.Ioptest.dao;

public class UserOracleImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("获取Oracle数据");
    }
}
