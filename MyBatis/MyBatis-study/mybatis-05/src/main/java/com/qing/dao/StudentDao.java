package com.qing.dao;

import com.qing.pojo.Student;

import java.util.List;

public interface StudentDao {
    //获取全部学生及老师信息
    List<Student> getStudents();

    //获取全部学生及老师信息(接口方法)
    List<Student> getStudents2();
}
