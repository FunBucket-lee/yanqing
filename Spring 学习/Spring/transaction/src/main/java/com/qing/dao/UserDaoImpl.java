package com.qing.dao;

import com.qing.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    @Override
    public List<User> selectUser() {
        UserDao userDao = getSqlSession().getMapper(UserDao.class);
        User user = new User(5, "Dior", "1111111");
        userDao.addUser(user);
        userDao.deleteUser(5);
        return userDao.selectUser();
    }

    @Override
    public int addUser(User user) {
        UserDao userDao = getSqlSession().getMapper(UserDao.class);
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        UserDao userDao = getSqlSession().getMapper(UserDao.class);
        return userDao.deleteUser(1);
    }
}
