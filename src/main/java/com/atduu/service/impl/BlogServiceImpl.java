package com.atduu.service.impl;

import com.atduu.NotFoundException;
import com.atduu.dao.BlogDao;
import com.atduu.pojo.Blog;
import com.atduu.pojo.Type;
import com.atduu.service.BlogService;
import com.atduu.util.MarkdownUtils;
import com.atduu.util.MyUtils;
import com.atduu.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/13 15:52
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Transactional
    @Override
    public Blog getBlogById(Long id) {
        return blogDao.findById(id).orElse(null);
    }


    /**
     * 后端展示分页
     * @param pageable
     * @param blog
     * @return
     */
    @Transactional
    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogDao.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<>();

                if(!"".equals(blog.getTitle()) && blog.getTitle() !=null){
                    predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                }

                if (blog.getTypeId() !=null){
                    predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId() ));
                }
                if (blog.isRecommend()){
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }

                query.where(predicates.toArray(new Predicate[predicates.size()]));

                return null;
            }
        },pageable);
    }

    /**
     * 前端展示分页
     * @param pageable
     * @return
     */
    @Transactional
    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogDao.findAll(pageable);
    }

    @Override
    public Page<Blog> listBlog (String query , Pageable pageable) {
        return blogDao.findByQuery(query,pageable);
    }

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {

        blog.setViews(0);

        blog.setCreateTime(new Date());

        blog.setUpdateTime(new Date());

        return blogDao.save(blog);
    }

    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) {

        Blog b = blogDao.findById(id).get();

        if (b == null){
            throw new NotFoundException("该博客不存在");
        }

        //过滤了属性值为空的属性
        BeanUtils.copyProperties( blog , b, MyUtils.getNullPropertyNames(blog));

        b.setUpdateTime(new Date());

        return blogDao.save(b);
    }

    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteById(id);
    }

    @Override
    public List<Blog> listRecommendBlogTop(Integer size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "updateTime");

        Pageable pageable = PageRequest.of(0,size,sort);

        return blogDao.findTop(pageable);

    }

    @Override
    public Blog getAndConvert(Long id) {

        Blog blog = blogDao.findById(id).get();

        Blog b = new Blog();

        BeanUtils.copyProperties(blog, b);

        String content = b.getContent();

        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));

        return b;
    }
}
