package com.qing.test;

import com.qing.dao.CourseDao;
import com.qing.entity.Course;
import com.qing.entity.Student;
import com.qing.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class TestCourse1 {
    private static final SqlSession session = MyBatisUtil.getSession();
    private static final Scanner scanner = new Scanner(System.in);
    private static final CourseDao courseDao = session.getMapper(CourseDao.class);

    public static void main(String[] args) {
        findCourseById();
    }

    private static void findCourseById() {
        System.out.print("请输入课程编号：");
        int courseid = scanner.nextInt();
        Course course = courseDao.findCourseById(courseid);

        System.out.println(course);
        System.out.println("选择该课程学生有：");
        List<Student> students = course.getStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
