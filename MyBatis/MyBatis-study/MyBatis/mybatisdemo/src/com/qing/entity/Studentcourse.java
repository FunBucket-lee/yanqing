package com.qing.entity;

public class Studentcourse {
    private int id;
    private int studentid;
    private int courseid;

    public Studentcourse(int id, int studentid, int courseid) {
        this.id = id;
        this.studentid = studentid;
        this.courseid = courseid;
    }

    public Studentcourse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        "\tstudentid=" + studentid +
                        "\tcourseid=" + courseid;
    }
}
