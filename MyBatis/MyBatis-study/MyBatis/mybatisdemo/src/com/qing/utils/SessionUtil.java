package com.qing.utils;

import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SessionUtil {
    static SqlSession sqlSession = null;
    //1、读取主配置文件 mybatis-config.xml
    //2、根据主配置文件 mybatis-config.xml 构建SqlSessionDactory对象
    //3、根据SqlSessionFactory创建SqlSession
    public static SqlSession getSqlSession(){
        final String resource = "mybatis-config.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sessionFactory = builder.build(reader);
            sqlSession = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

}
