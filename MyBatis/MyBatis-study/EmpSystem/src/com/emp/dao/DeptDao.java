package com.emp.dao;

import com.emp.pojo.Dept;

public interface DeptDao {
    Dept findDeptById(int deptno);
}
