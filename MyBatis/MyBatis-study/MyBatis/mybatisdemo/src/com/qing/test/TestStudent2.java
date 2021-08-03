package com.qing.test;

import com.qing.dao.StudentDao;
import com.qing.entity.Course;
import com.qing.entity.Student;
import com.qing.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TestStudent2 {
    public static void main(String[] args) {
//        findAll();
//        findByID();
//        findByGenderAndAge();
//        findByGenderAndAge2();
//        findByGenderAndAge3();
        findStudentCourseByID();
    }

    private static void findStudentCourseByID() {
        System.out.print("请输入id: ");
        int id = scanner.nextInt();
        Student student = studentDao.findStudentCourseByID(id);
        System.out.println(student.toString());
        System.out.println("该学生选择一下课程");
        List<Course> courses = student.getCourses();
        for (Course cours : courses) {
            System.out.println(cours.toString());
        }
    }

    private static void findByID() {
        System.out.print("请输入id: ");
        int id = scanner.nextInt();
        Student student = studentDao.findStudentById2(id);
        System.out.println(student.toString());
    }

    private static void findByGenderAndAge3() {
        HashMap<Object, Object> map = new HashMap<>();
        System.out.print("请输入年龄: ");
        int age = scanner.nextInt();
        System.out.print("请输入性别: ");
        String sex = scanner.next();
        map.put("sex", sex);
        map.put("age", age);
        System.out.println("id\t名字\t性别\t年龄");
        List<Student> list = studentDao.findByGenderAndAge3(map);
        if (list.size() <= 0) {
            System.out.println("查询失败");
        }
        for (Student student1 : list) {
            student1.Show();
        }
    }

    private static void findByGenderAndAge2() {
        System.out.print("请输入年龄: ");
        int age = scanner.nextInt();
        System.out.print("请输入性别: ");
        String sex = scanner.next();
        Student student = new Student(0, null, sex, age);
        System.out.println("id\t名字\t性别\t年龄");
        List<Student> list = studentDao.findByGenderAndAge2(student);
        if (list.size() <= 0) {
            System.out.println("查询失败");
        }
        for (Student student1 : list) {
            student1.Show();
        }
    }

    private static void findByGenderAndAge() {
        System.out.print("请输入年龄: ");
        int age = scanner.nextInt();
        System.out.print("请输入性别: ");
        String sex = scanner.next();
        System.out.println("id\t名字\t性别\t年龄");
        List<Student> list = studentDao.findByGenderAndAge(sex, age);
        if (list.size() <= 0) {
            System.out.println("查询失败");
        }
        for (Student student : list) {
            student.Show();
        }
    }

    private static SqlSession session = MyBatisUtil.getSession();
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDao studentDao = session.getMapper(StudentDao.class);

    private static void findAll() {
        System.out.println("id\t名字\t性别\t年龄");
        List<Student> list;
        list = studentDao.findAllStudents();
        if (list.size() <= 0) {
            System.out.println("查询失败");
        }
        for (Student student : list) {
            student.Show();
        }
    }
}
