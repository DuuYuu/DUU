package com.atduu.service;

import com.atduu.pojo.Blog;
import com.atduu.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created  by DuuYuu on 2021/12/13 15:48
 **/
public interface BlogService {

    Blog getBlogById(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId , Pageable pageable);

    Page<Blog> listBlog(String query , Pageable pageable);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id , Blog blog);

    void deleteBlog(Long id);

    List<Blog> listRecommendBlogTop(Integer size);

    Blog getAndConvert(Long id);

    Map<String, List<Blog>> archiveBlog();

    Long countBlog();

}
