package com.qing.dao;

import com.qing.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> findAllStudents();

    Student findStudentById(int sid);

    Student findStudentById2(int sid);

    int addStudent(Student student);

    int addAutoStudent(Student student);

    int deleteStudent(int sid);

    int updateStudent(Student student);

    List<Student> findByName(String name);

    List<Student> findByGenderAndAge(@Param("sex") String sex, @Param("age") int age);

    List<Student> findByGenderAndAge2(Student student);

    List<Student> findByGenderAndAge3(Map map);

    Student findStudentCourseByID(int id);
}
