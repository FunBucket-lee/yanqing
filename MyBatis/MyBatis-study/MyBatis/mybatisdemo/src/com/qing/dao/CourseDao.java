package com.qing.dao;

import com.qing.entity.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseDao {
    Course findCourseById(int courseid);

    @Select("select courseid as cid,coursename as cname from course")
    List<Course> findAll();
}
