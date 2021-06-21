package com.qing.dao;

import com.qing.pojo.Teacher;
import com.qing.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.apache.log4j.Logger;


public class MyTest {

    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void test1() {
        SqlSession session = MyBatisUtils.getSession();
        TeacherDao teacherDao = session.getMapper(TeacherDao.class);
        Teacher teacher = teacherDao.getTeacher(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
        session.close();
    }
}
