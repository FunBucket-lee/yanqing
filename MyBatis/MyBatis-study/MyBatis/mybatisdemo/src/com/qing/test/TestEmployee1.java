package com.qing.test;

import com.qing.dao.ClassesDao;
import com.qing.dao.EmployeeDao;
import com.qing.entity.Employee;
import com.qing.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class TestEmployee1 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SqlSession session = MyBatisUtil.getSession();
    private static final EmployeeDao employeeDap = session.getMapper(EmployeeDao.class);

    public static void main(String[] args) {
//    findByEmpid();
        findByEmpid1();
    }

    private static void findByEmpid1() {
        System.out.print("请输入经理编号：");
        int leader = scanner.nextInt();
        Employee employee = employeeDap.findByEmpid1(leader);
        System.out.println("经理编号:" + employee.getEmpid() +
                "\t员工名字:" + employee.getEmpname() +
                "\t职位:" + employee.getJob());
        System.out.println("下属有：");
        List<Employee> employees = employee.getEmployees();
        for (Employee employee1 : employees) {
            System.out.println("员工编号:" + employee1.getEmpid() +
                    "\t员工名字:" + employee1.getEmpname() +
                    "\t职位:" + employee1.getJob());
        }
    }

    private static void findByEmpid() {
        System.out.print("请输入员工编号：");
        int empid = scanner.nextInt();
        Employee employee = employeeDap.findByEmpid(empid);
        System.out.println(employee);
    }

}
