package com.qing.entity;

import java.util.List;

public class Course {
    private String cid;
    private String cname;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Course() {
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

    @Override
    public String toString() {
        return
                "课程编号:" + cid + '\t' +
                        "课程名字:" + cname + '\t';
    }
}
