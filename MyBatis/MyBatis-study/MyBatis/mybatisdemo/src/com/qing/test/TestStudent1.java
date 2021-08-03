package com.qing.test;

import com.qing.dao.StudentDaoImpl;
import com.qing.entity.Student;

import java.util.List;
import java.util.Scanner;

public class TestStudent1 {
    public static void main(String[] args) {
        findAllStudents();
//        findStudentById();
//        addStudent();
//        addAutoStudent();
//        delStudent();
//        updateStudent();
//        findByName();
    }

    private static void findByName() {
        System.out.print("请输入要查找的学生名字: ");
        String name = scanner.next();
        List<Student> students = studentDao.findByName(name);
        System.out.println("id\t名字\t性别\t年龄");
        for (Student student : students) {
            student.Show();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDaoImpl studentDao = new StudentDaoImpl();

    private static void updateStudent() {
        System.out.print("请输入学生id: ");
        int id = scanner.nextInt();
        System.out.print("请输入学生新姓名: ");
        String sname = scanner.next();
        System.out.print("请输入学生新性别: ");
        String sex = scanner.next();
        System.out.print("请输入学生新年龄: ");
        int age = scanner.nextInt();
        Student student = new Student(id, sname, sex, age);
        int res = studentDao.updateStudent(student);
        if (res > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    private static void delStudent() {
        System.out.print("请输入学生id: ");
        int id = scanner.nextInt();
        int res = studentDao.deleteStudent(id);
        if (res > 0) {
            System.out.println("删除成功");
        }
    }

    private static void addAutoStudent() {
        System.out.print("请输入学生姓名: ");
        String sname = scanner.next();
        System.out.print("请输入学生性别: ");
        String sex = scanner.next();
        System.out.print("请输入学生年龄: ");
        int age = scanner.nextInt();
        Student student = new Student();
        student.setSname(sname);
        student.setSex(sex);
        student.setAge(age);
        int res = studentDao.addAutoStudent(student);
        if (res > 0) {
            System.out.println("插入成功");
            System.out.println(student.getSid());
        } else {
            System.out.println("插入失败");
        }
    }

    private static void addStudent() {
        System.out.print("请输入学生id: ");
        int id = scanner.nextInt();
        System.out.print("请输入学生姓名: ");
        String sname = scanner.next();
        System.out.print("请输入学生性别: ");
        String sex = scanner.next();
        System.out.print("请输入学生年龄: ");
        int age = scanner.nextInt();
        Student student = new Student(id, sname, sex, age);
        int res = studentDao.addStudent(student);
        if (res > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

    private static void findStudentById() {
        System.out.print("请输入要查询的学生id： ");
        int sid = scanner.nextInt();
        System.out.println("id\t名字\t性别\t年龄");
        Student student = studentDao.findStudentById(sid);
        if (student == null) {
            System.out.println("查询失败");
            return;
        }
        student.Show();
    }

    private static void findAllStudents() {
        System.out.println("id\t名字\t性别\t年龄");
        List<Student> list;
        list = studentDao.findAllStudents();
        for (Student student : list) {
            student.Show();
        }
    }
}
