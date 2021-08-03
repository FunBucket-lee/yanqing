package com.emp.test;

import com.emp.dao.DeptDao;
import com.emp.dao.EmpDao;
import com.emp.pojo.Dept;
import com.emp.pojo.Emp;
import com.emp.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class UnitTest2 {
    private static final SqlSession session = MyBatisUtil.getSession();
    private static final DeptDao deptDao = session.getMapper(DeptDao.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        findDeptById();
    }

    private static void findDeptById() {
        System.out.print("请输入部门编号：");
        int deptno = scanner.nextInt();
        Dept dept = deptDao.findDeptById(deptno);
        System.out.println(dept);
        System.out.println("以下为该部门员工");
        System.out.println("员工编号\t名字\t职位\t经理编号\t入职日期\t工资\t奖金\t部门编号");
        List<Emp> emps = dept.getEmps();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }
}
