package com.emp.test;

import com.emp.dao.EmpDao;
import com.emp.pojo.Emp;
import com.emp.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UnitTest {
    public static void main(String[] args) throws ParseException {
        queryAll();
        queryByNo();
        addEmp();
        updateEmp();
        deleteEmp();
        queryByDeptnoAndJob1();
        queryByDeptnoAndJob2();
        queryByDeptnoAndJob3();
    }

    private static final SqlSession session = MyBatisUtil.getSession();
    private static final EmpDao empDao = session.getMapper(EmpDao.class);
    private static final Scanner scanner = new Scanner(System.in);

    //6.根据部门编号和职位查询员工（分别用三种方法实现）
    private static void queryByDeptnoAndJob3() {
        System.out.print("请输入部门编号: ");
        int deptno = scanner.nextInt();
        System.out.print("请输入职位: ");
        String job = scanner.next();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("deptno", deptno);
        map.put("job", job);
        List<Emp> emps = empDao.queryByDeptnoAndJob3(map);
        System.out.println("员工编号\t名字\t职位\t经理编号\t入职日期\t工资\t奖金\t部门编号");
        for (Emp emp1 : emps) {
            System.out.println(emp1.toString());
        }
    }

    private static void queryByDeptnoAndJob2() {
        System.out.print("请输入部门编号: ");
        int deptno = scanner.nextInt();
        System.out.print("请输入职位: ");
        String job = scanner.next();
        Emp emp = new Emp();
        emp.setDeptno(deptno);
        emp.setJob(job);
        List<Emp> emps = empDao.queryByDeptnoAndJob2(emp);
        System.out.println("员工编号\t名字\t职位\t经理编号\t入职日期\t工资\t奖金\t部门编号");
        for (Emp emp1 : emps) {
            System.out.println(emp1.toString());
        }
    }

    private static void queryByDeptnoAndJob1() {
        System.out.print("请输入部门编号: ");
        int deptno = scanner.nextInt();
        System.out.print("请输入职位: ");
        String job = scanner.next();
        List<Emp> emps = empDao.queryByDeptnoAndJob1(deptno, job);
        System.out.println("员工编号\t名字\t职位\t经理编号\t入职日期\t工资\t奖金\t部门编号");
        for (Emp emp : emps) {
            System.out.println(emp.toString());
        }
    }

    //删除员工
    private static void deleteEmp() {
        System.out.print("请输入要删除员编号: ");
        int empno = scanner.nextInt();
        int res = empDao.deleteEmp(empno);
        session.commit();
        if (res <= 0) {
            System.out.println("删除失败");
        } else {
            System.out.println("删除成功");
        }
    }

    //修改员工
    private static void updateEmp() throws ParseException {
        System.out.print("请输入要修改员工编号: ");
        int empno = scanner.nextInt();
        System.out.print("请输入新员工姓名：");
        String ename = scanner.next();
        System.out.print("请输入新员工职位：");
        String job = scanner.next();
        System.out.print("请输入新经理编号：");
        int mgr = scanner.nextInt();
        System.out.print("请输新入职日期（yyyy-MM-dd）:");
        String date = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date hiredate = sdf.parse(date);
        System.out.print("请输入新员工工资：");
        double sal = scanner.nextInt();
        System.out.print("请输入新员工奖金:");
        double comm = scanner.nextInt();
        System.out.print("请输入新部门编号：");
        int deptno = scanner.nextInt();
        Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
        int res = empDao.updateEmp(emp);
        session.commit();
        if (res <= 0) {
            System.out.println("修改失败");
        } else {
            System.out.println("修改成功");
        }
    }


    //增加员工
    private static void addEmp() throws ParseException {
        System.out.print("请输入员工编号: ");
        int empno = scanner.nextInt();
        System.out.print("请输入员工姓名：");
        String ename = scanner.next();
        System.out.print("请输入员工职位：");
        String job = scanner.next();
        System.out.print("请输入经理编号：");
        int mgr = scanner.nextInt();
        System.out.print("请输入职日期（yyyy-MM-dd）:");
        String date = scanner.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date hiredate = sdf.parse(date);
        System.out.print("请输入员工工资：");
        double sal = scanner.nextInt();
        System.out.print("请输入员工奖金:");
        double comm = scanner.nextInt();
        System.out.print("请输入部门编号：");
        int deptno = scanner.nextInt();
        Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
        int res = empDao.addEmp(emp);
        session.commit();
        if (res <= 0) {
            System.out.println("增加失败");
        } else {
            System.out.println("增加成功");
        }

    }

    //按编号查询所有员工
    private static void queryByNo() {
        System.out.print("请输入要查找员编号: ");
        int empno = scanner.nextInt();
        Emp emp = empDao.queryByNo(empno);
        if (emp == null) {
            System.out.println("查询失败");
        } else {
            System.out.println(emp.toString());
        }
    }

    //查询所有员工
    private static void queryAll() {
        List<Emp> empList = empDao.queryAll();
        System.out.println("员工编号\t名字\t职位\t经理编号\t入职日期\t工资\t奖金\t部门编号");
        for (Emp emp : empList) {
            System.out.println(emp.toString());
        }
    }
}
