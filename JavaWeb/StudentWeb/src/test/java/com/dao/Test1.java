package com.dao;

import com.qing.dao.StudentDao;
import com.qing.pojo.Student;
import com.qing.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

public class Test1 {
    @Test
    void selTest1() {
        SqlSession session = MyBatisUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    void addTest1() {
        SqlSession session = MyBatisUtil.getSession();
        Scanner scanner = new Scanner(System.in);
        StudentDao studentDao = session.getMapper(StudentDao.class);
        System.out.print("请输入学生id: ");
        int id = scanner.nextInt();
        System.out.print("请输入学生姓名: ");
        String studentname = scanner.next();
        System.out.print("请输入学生性别: ");
        String gender = scanner.next();
        System.out.print("请输入学生年龄: ");
        int age = scanner.nextInt();
        System.out.print("请输入学生地址: ");
        String address = scanner.next();
        System.out.print("请输入数学成绩: ");
        int math = scanner.nextInt();
        System.out.print("请输入英语成绩: ");
        int english = scanner.nextInt();
        Student student = new Student(id, studentname, gender, age, address, math, english);
        int res = studentDao.addStudent(student);
        session.commit();
        if (res <= 0) {
            System.out.println("插入失败");
        }else {
            System.out.println("插入成功");
        }
    }
}
