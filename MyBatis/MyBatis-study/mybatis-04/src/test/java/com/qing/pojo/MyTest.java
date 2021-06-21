package com.qing.pojo;

import com.qing.dao.UserDao;
import com.qing.utils.MyBatisUtils;
import org.apache.log4j.Logger;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void test1() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.getUserList();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession session = MyBatisUtils.getSession();
        UserDao userDao = session.getMapper(UserDao.class);
        User user = new User(4, "FunBucket", "1008611");
        userDao.addUser(user);
        System.out.println("增加用户成功");
        session.close();
    }

    @Test
    public void test3() {
        SqlSession session = MyBatisUtils.getSession();
        UserDao userDao = session.getMapper(UserDao.class);
        userDao.deleteUser(4);
        System.out.println("删除用户成功");
        session.close();

    }

    @Test
    public void test4(){
        SqlSession session = MyBatisUtils.getSession();
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.getUserByID(1);
        System.out.println(user);
    }
}
