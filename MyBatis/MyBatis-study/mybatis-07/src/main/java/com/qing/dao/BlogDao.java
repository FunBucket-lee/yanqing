package com.qing.dao;

import com.qing.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogDao {
    void addBlog(Blog blog);

    void updateBlog(Map map);

    List<Blog> queryBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);
}
