package com.qing.test;

import com.qing.dao.ClassesDao;
import com.qing.entity.Classes;
import com.qing.entity.Student;
import com.qing.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class TestClasses1 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SqlSession session = MyBatisUtil.getSession();
    private static final ClassesDao classesDao = session.getMapper(ClassesDao.class);

    public static void main(String[] args) {
        findByNo();
    }

    private static void findByNo() {
        System.out.print("请输入班级号: ");
        String classno = scanner.next();
        List<Classes> classes = classesDao.findByNo(classno);
        if (classes.size() == 0) {
            System.out.println("查询失败");
        }
        for (Classes aClass : classes) {
            System.out.println(aClass.toString());
            for (Student student : aClass.getStudents()) {
                System.out.println(student.toString());
            }
        }
    }
}
