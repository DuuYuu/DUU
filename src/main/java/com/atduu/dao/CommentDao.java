package com.atduu.dao;

import com.atduu.pojo.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/18 15:42
 **/
public interface CommentDao extends JpaRepository<Comment , Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId , Sort sort);

}
