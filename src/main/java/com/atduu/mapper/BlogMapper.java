package com.atduu.mapper;

import com.atduu.pojo.Blog;
import com.atduu.vo.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/13 15:53
 **/
@Mapper
@Repository
public interface BlogMapper {

    Blog queryBlogById(Long id);

    List<Blog> queryBlogByTitleOrTypeIdOrRecommend(BlogQuery blog);

    List<Blog> queryAllBlogs(Blog blog);

    int save(Blog blog);

    int update(Blog blog);

    int delete(Long id);
}
