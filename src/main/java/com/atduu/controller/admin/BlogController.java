package com.atduu.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author DuuYuu
 * @Date 2021/12/12 15:19
 **/
@Controller
@RequestMapping("/admin")
public class BlogController {

    @GetMapping("/blogs")
    public String blogs(){
        return "admin/blogs";
    }


}
