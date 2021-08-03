package com.qing.dao;

import com.qing.entity.Student;
import com.qing.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAllStudents() {
        List<Student> list;
        //1、读取主配置文件 mybatis-config.xml
        SqlSession session = MyBatisUtil.getSession();
        //4、根据SqlSession对象session的selectList方法执行数据库操作，返回映射后文件
        list = session.selectList("com.qing.dao.IStudentDao.findAllStudents");
        MyBatisUtil.closeSession();
        return list;
    }

    @Override
    public Student findStudentById(int sid) {
        Student student;
        SqlSession session = MyBatisUtil.getSession();
        student = session.selectOne("com.qing.dao.IStudentDao.findStudentById", sid);
        MyBatisUtil.closeSession();
        return student;
    }

    @Override
    public Student findStudentById2(int sid) {
        return null;
    }

    @Override
    public int addStudent(Student student) {
        SqlSession session = MyBatisUtil.getSession();
        int insert = session.insert("com.qing.dao.IStudentDao.addStudent", student);
        session.commit();
        MyBatisUtil.closeSession();
        return insert;
    }

    @Override
    public int addAutoStudent(Student student) {
        SqlSession session = MyBatisUtil.getSession();
        int insert = session.insert("com.qing.dao.IStudentDao.addAutoStudent", student);
        session.commit();
        MyBatisUtil.closeSession();
        return insert;
    }

    @Override
    public int deleteStudent(int sid) {
        SqlSession session = MyBatisUtil.getSession();
        int delete = session.delete("com.qing.dao.IStudentDao.deleteStudent", sid);
        session.commit();
        MyBatisUtil.closeSession();
        return delete;
    }

    @Override
    public int updateStudent(Student student) {
        SqlSession session = MyBatisUtil.getSession();
        int update = session.update("com.qing.dao.IStudentDao.updateStudent", student);
        session.commit();
        return update;
    }

    @Override
    public List<Student> findByName(String sname) {
        SqlSession session = MyBatisUtil.getSession();
        List<Student> list = session.selectList("com.qing.dao.IStudentDao.findByName", sname);
        MyBatisUtil.closeSession();
        return list;
    }

    @Override
    public List<Student> findByGenderAndAge(String sex, int age) {
        return null;
    }

    @Override
    public List<Student> findByGenderAndAge2(Student student) {
        return null;
    }

    @Override
    public List<Student> findByGenderAndAge3(Map map) {
        return null;
    }

    @Override
    public Student findStudentCourseByID(int id) {
        return null;
    }

    public List<Student> findAll() {
        List<Student> list;
        SqlSession session = MyBatisUtil.getSession();
        list = session.selectList("com.qing.dao.IStudentDao.findAllStudents");
        MyBatisUtil.closeSession();
        return list;
    }
}
