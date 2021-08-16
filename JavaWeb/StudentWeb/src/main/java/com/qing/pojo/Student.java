package com.qing.pojo;

public class Student {
    private int id;
    private String studentname;
    private String gender;
    private int age;
    private String address;
    private int math;
    private int english;

    public Student(int id, String studentname, String gender, int age, String address, int math, int english) {
        this.id = id;
        this.studentname = studentname;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.math = math;
        this.english = english;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "StudentDao{" +
                "id=" + id +
                ", studentname='" + studentname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", math=" + math +
                ", english=" + english +
                '}';
    }
}
