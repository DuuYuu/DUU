package com.atduu.controller;

import com.atduu.Const.Const;
import com.atduu.service.BlogService;
import com.atduu.service.TagService;
import com.atduu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/index")
    public String index(@PageableDefault( size = Const.INDEX_PAGE_SIZE , sort = {"updateTime"} ,
            direction = Sort.Direction.DESC) Pageable pageable , Model model){

        model.addAttribute("page", blogService.listBlog(pageable));

        model.addAttribute("types", typeService.listTypeTop(Const.INDEX_TYPES_COUNT));

        model.addAttribute("tags", tagService.listTagTop(Const.INDEX_TAGS_COUNT));

        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(Const.INDEX_RECOMMEND_BLOG_COUNT));

        return "index";

    }

    @GetMapping("/blog/{id}")
    public String Blog(@PathVariable Long id ,Model model){

        model.addAttribute("blog", blogService.getAndConvert(id));

        return "blog";

    }

    @PostMapping("/search")
    public String search(@PageableDefault( size = Const.INDEX_PAGE_SIZE , sort = {"updateTime"} ,
            direction = Sort.Direction.DESC) Pageable pageable , @RequestParam String query , Model model){

        model.addAttribute("page", blogService.listBlog("%"+query+"%", pageable));

        model.addAttribute("query", query);

        return "search";

    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model){

        model.addAttribute("newblogs" , blogService.listRecommendBlogTop(3));

        return "index :: newblogList";
    }

}
