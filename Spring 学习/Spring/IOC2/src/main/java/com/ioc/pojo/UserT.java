package com.ioc.pojo;

import java.util.Objects;

public class UserT {
    private String name;

    public UserT(String name) {
        this.name = name;
    }

    public UserT() {
        System.out.println("UserTwo的无参构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserT userT = (UserT) o;
        return Objects.equals(name, userT.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String
    toString() {
        return "UserT{" +
                "name='" + name + '\'' +
                '}';
    }
}
