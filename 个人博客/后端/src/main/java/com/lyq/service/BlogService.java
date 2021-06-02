package com.lyq.service;

import com.lyq.po.Blog;
import com.lyq.vo.BlogQuery;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {
    Blog getBlog(Long id);

    Blog getAndConvert(Long id) throws NotFoundException;

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Page<Blog> listBlog(String query,Pageable pageable);

    Map<String,List<Blog>> archiveBlog();

    List<Blog> listRecommendBlogTop(Integer size);

    Blog saveBlog(Blog blog);

    Long countBlog();

    Blog updateBlog(Long id, Blog blog) throws NotFoundException;

    void deleteBlog(Long id);
}
