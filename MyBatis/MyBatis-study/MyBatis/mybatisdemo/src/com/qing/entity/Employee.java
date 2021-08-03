package com.qing.entity;

import java.util.List;

public class Employee {
    private int empid;
    private String empname;
    private String job;
    private Employee leader;
    private List<Employee> employees;

    public Employee(int empid, String empname, String job, Employee leader) {
        this.empid = empid;
        this.empname = empname;
        this.job = job;
        this.leader = leader;
    }

    public Employee() {
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "员工编号:" + empid +
                "\t员工名字:" + empname +
                "\t职位:" + job +
                "\t领导编号:" + leader.getEmpid() + "\t领导名字:" +
                leader.getEmpname() + "\t领导职位" + leader.getJob();
    }
}
