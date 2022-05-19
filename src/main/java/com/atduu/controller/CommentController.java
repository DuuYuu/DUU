package com.atduu.controller;

import com.atduu.Const.Const;
import com.atduu.pojo.Comment;
import com.atduu.pojo.User;
import com.atduu.service.BlogService;
import com.atduu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Created  by DuuYuu on 2021/12/18 15:35
 **/
@Controller
public class CommentController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/{blogId}")
    public  String comments(@PathVariable Long blogId , Model model){

        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));

        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment , HttpSession session){

        Long blogId = comment.getBlog().getId();

        User user = (User)session.getAttribute("user");

        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
            comment.setNickname(user.getNickname());
        }else{
            comment.setAvatar(Const.COMMENT_DEFAULT_AVATAR);
        }

        comment.setBlog(blogService.getBlogById(blogId));

        commentService.saveComment(comment);

        return "redirect:/comments/" + comment.getBlog().getId();
    }
}
