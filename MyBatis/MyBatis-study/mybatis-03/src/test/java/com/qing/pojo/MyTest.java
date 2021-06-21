package com.qing.pojo;

import com.qing.dao.UserDao;

import com.qing.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void selectUser() {
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MyBatisUtils.getSqlSession(UserDao.class);
        UserDao mapper = session.getMapper(UserDao.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 1);
        map.put("sizePage", 2);
        List<User> users = mapper.getUser(map);
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }
}
