package com.emp.pojo;

import java.util.List;

public class Dept {
    private int deptno;
    private String dname;
    private String loc;
    private List<Emp> emps;

    public Dept(int deptno, String dname, String loc, List<Emp> emps) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        this.emps = emps;
    }

    public Dept() {
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "部门编号:" + deptno +
                "\t部门名字:" + dname +
                "\t部门地址:" + loc;
    }
}
