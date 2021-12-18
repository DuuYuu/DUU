package com.atduu.service;

import com.atduu.pojo.Comment;

import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/18 15:40
 **/
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

}
