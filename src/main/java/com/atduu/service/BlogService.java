package com.atduu.service;

import com.atduu.pojo.Blog;
import com.atduu.vo.BlogQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/13 15:48
 **/
public interface BlogService {

    Blog getBlogById(Long id);

    List<Blog> getAllBlog(Blog blog);

    PageInfo<Blog> findBlogByPages(BlogQuery blog , int pageNum , int pageSize);

    int saveBlog(Blog blog);

    int updateBlog(Long id , Blog blog);

    int deleteBlog(Long id);

}
