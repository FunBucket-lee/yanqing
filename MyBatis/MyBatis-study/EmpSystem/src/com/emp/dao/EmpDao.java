package com.emp.dao;

import com.emp.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    //    1.查询所有员工
    List<Emp> queryAll();

    //2.根据员工编号查询员工
    Emp queryByNo(@Param("empno") int empno);

    //2-1.根据员工编号查询员工及部门信息
    Emp queryByNoWithDept(@Param("empno") int empno);

    //3.添加员工
    int addEmp(Emp emp);

    //4.修改员工
    int updateEmp(Emp emp);

    //5.删除员工
    int deleteEmp(int empno);

    //6.根据部门编号和职位查询员工（分别用三种方法实现）
    List<Emp> queryByDeptnoAndJob1(@Param("deptno") int deptno, @Param("job") String job);

    List<Emp> queryByDeptnoAndJob2(Emp emp);

    List<Emp> queryByDeptnoAndJob3(Map map);
}
