package com.qing.dao;

import com.qing.entity.Course;

public interface CourseDao {
    Course findCourseById(int courseid);
}
