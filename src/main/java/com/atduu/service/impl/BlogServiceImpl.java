package com.atduu.service.impl;

import com.atduu.NotFoundException;
import com.atduu.mapper.BlogMapper;
import com.atduu.pojo.Blog;
import com.atduu.service.BlogService;
import com.atduu.vo.BlogQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/13 15:52
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Blog getBlogById(Long id) {
        return blogMapper.queryBlogById(id);
    }

    @Override
    public List<Blog> getAllBlog(Blog blog) {
        return blogMapper.queryAllBlogs(blog);
    }

    @Override
    public PageInfo<Blog> findBlogByPages(BlogQuery blog, int pageNum, int pageSize) {

        String orderBy = "id desc"; //根据id降序

        PageHelper.startPage(pageNum, pageSize,orderBy);

        List<Blog> list = blogMapper.queryBlogByTitleOrTypeIdOrRecommend(blog);

        return new PageInfo<Blog>(list);

    }

    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        return blogMapper.save(blog);
    }

    @Transactional
    @Override
    public int updateBlog(Long id, Blog blog) {

        Blog b =  blogMapper.queryBlogById(id);

        if(b==null){
            throw new NotFoundException("该博客不存在");
        }

        return blogMapper.update(blog);
    }

    @Transactional
    @Override
    public int deleteBlog(Long id) {
        return blogMapper.delete(id);
    }
}
