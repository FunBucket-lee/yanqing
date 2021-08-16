package com.qing.dao;

import com.qing.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {
    //查询所有学生
    @Select("select * from student")
    List<Student> findAll();

    //按学号查询学生
    @Select("select * from student where id = #{id}")
    Student findAllById(@Param("id") int id);

    //新增学生
    @Insert("insert into student values(#{id},#{studentname},#{age},#{gender},#{address},#{math},#{english})")
    int addStudent(Student student);

    //修改学生
    @Update("update student set studentname = #{studentname},age=#{age},gender=#{gender},address=#{address},math=#{math},english=#{english} where id=#{id}")
    int updateStudent(Student student);

    //删除学生
    @Delete("delete from student where id=#{id}")
    int deleteStudent(@Param("id") int id);
}
