package com.qing.dao;

import com.qing.pojo.Blog;
import com.qing.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void addTest() {
        SqlSession session = MyBatisUtils.getSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        Blog blog = new Blog();
        blog.setId("2");
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("李燕青");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        blogDao.addBlog(blog);

        blog.setId("3");
        blog.setTitle("Java如此简单");
        blogDao.addBlog(blog);

        blog.setId("4");
        blog.setTitle("Spring如此简单");
        blogDao.addBlog(blog);

        blog.setId("5");
        blog.setTitle("微服务如此简单");
        blogDao.addBlog(blog);
        session.close();
    }

    @Test
    public void updateTeste() {
        SqlSession session = MyBatisUtils.getSession();
        BlogDao dao = session.getMapper(BlogDao.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("title", "mysql很简单");
        map.put("author", "燕青");
        dao.updateBlog(map);
        session.close();
    }

    @Test
    public void queryTest() {
        SqlSession session = MyBatisUtils.getSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("author", "燕青");
        List<Blog> blogs = blogDao.queryBlog(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void queryChooseTest() {
        SqlSession session = MyBatisUtils.getSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "mysql很简单");
        map.put("author", "燕青");
        List<Blog> blogs = blogDao.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }

    @Test
    public void queryForeachTest() {
        SqlSession session = MyBatisUtils.getSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        Map map = new HashMap();
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        map.put("ids",list);
        List<Blog> blogs = blogDao.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }
}
