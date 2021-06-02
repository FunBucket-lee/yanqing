package com.lyq.po;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_tag")
public class Tag {
    //标签属性

    @Id
    @GeneratedValue
    private long id;  //id
    @NotBlank(message = "标签名称不能为空")
    private String name;  //标签名

    @ManyToMany(mappedBy = "tags") //标签被维护
    private List<Blog> blogs = new ArrayList<>(); //标签对博客是多对多

    public Tag() {
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
