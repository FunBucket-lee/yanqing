package com.qing.dao;

import com.qing.pojo.User;
import com.qing.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void test1() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserByID(2);
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserByNP("燕青", "123456");
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "李燕青");
        map.put("pwd", "123456");
        User user = userDao.getUserByNP2(map);
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void test5() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User(4, "李青", "10086");
        userDao.addUser(user);
        System.out.println("增加成功");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userdao = sqlSession.getMapper(UserDao.class);
        User user = userdao.getUserByID(1);
        user.setPwd("1008611");
        userdao.updateUser(user);
        System.out.println("修改成功");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test7() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteUser(4);
        System.out.println("删除成功");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test8() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> user = userDao.getUserLike("%李%");
        for (User user1 : user) {
            System.out.println(user1.toString());
        }
        sqlSession.close();

    }
}
