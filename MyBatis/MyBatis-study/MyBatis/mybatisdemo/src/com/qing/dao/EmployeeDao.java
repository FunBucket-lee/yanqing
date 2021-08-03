package com.qing.dao;

import com.qing.entity.Employee;

public interface EmployeeDao {
    Employee findByEmpid(int empid);

    Employee findByEmpid1(int leader);
}
