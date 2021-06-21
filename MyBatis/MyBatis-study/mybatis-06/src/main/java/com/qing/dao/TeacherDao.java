package com.qing.dao;

import com.qing.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherDao {
    Teacher getTeacher(@Param("id") int id);
}
