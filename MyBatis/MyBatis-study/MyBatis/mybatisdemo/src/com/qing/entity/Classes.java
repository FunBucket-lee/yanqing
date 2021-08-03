package com.qing.entity;

import java.util.List;

public class Classes {
    private String cid;
    private String cname;
    private List<Student> students;

    public Classes(String cid, String cname, List<Student> students) {
        this.cid = cid;
        this.cname = cname;
        this.students = students;
    }

    public Classes() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "班级编号:" + cid +
                "  班级名称:" + cname;
    }
}
