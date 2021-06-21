package com.qing.dao;

import com.qing.pojo.Student;
import com.qing.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test1() {
        SqlSession session = MyBatisUtils.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> students = studentDao.getStudents2();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }
}
