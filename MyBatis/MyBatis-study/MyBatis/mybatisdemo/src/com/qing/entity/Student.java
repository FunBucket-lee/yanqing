package com.qing.entity;

import java.util.List;

public class Student {
    private int sid;
    private String sname;
    private String sex;
    private int age;
    private Classes classes;
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Student(int sid, String sname, String sex, int age) {
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void Show() {
        System.out.println(sid + "\t" + sname + "\t" + sex + "\t" + age + "\t");
    }

    @Override
    public String toString() {
        return "编号:" + sid + "\t名字:" + sname +
                "\t性别:" + sex +
                "\t年龄:" + age;
    }
}
