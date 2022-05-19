package com.atduu.controller;

import com.atduu.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created  by DuuYuu on 2021/12/19 15:34
 **/
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model){

        model.addAttribute("archiveMap", blogService.categoryBlog());

        model.addAttribute("blogCount", blogService.countBlog());

        return "archives";
    }

}
