package com.qing.dao;

import com.qing.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;


import java.util.List;


public class MyTest {

    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserDao mapper = (UserDao) context.getBean("userDao");
        List<User> user = mapper.selectUser();
        System.out.println(user);
    }
}
