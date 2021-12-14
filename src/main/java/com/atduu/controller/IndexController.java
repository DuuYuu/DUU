package com.atduu.controller;

import com.atduu.pojo.Const;
import com.atduu.service.BlogService;
import com.atduu.service.TagService;
import com.atduu.service.TypeService;
import com.atduu.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping({"/","/index"})
    public String index(@PageableDefault(size = Const.INDEX_PAGE_SIZE , sort = {"updateTime"} ,
            direction = Sort.Direction.DESC) Pageable pageable ,
                        BlogQuery blog, Model model){

        model.addAttribute("page", blogService.listBlog(pageable));

        model.addAttribute("types", typeService.listTypeTop(Const.INDEX_TYPES_COUNT));

        model.addAttribute("tags", tagService.listTagTop(Const.INDEX_TAGS_COUNT));

        return "index";

    }

    @GetMapping("/blog")
    public String Blog(){

        return "blog";

    }
}
