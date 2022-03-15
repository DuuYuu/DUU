package com.atduu.controller;

import com.atduu.Const.Const;
import com.atduu.pojo.Tag;
import com.atduu.service.BlogService;
import com.atduu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created  by DuuYuu on 2021/12/19 14:21
 **/
@Controller
public class TagShowController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService TagService ;

    @GetMapping("/tags/{id}")
    public String Tags(@PageableDefault( size = Const.INDEX_PAGE_SIZE , sort = {"updateTime"} ,
            direction = Sort.Direction.ASC) Pageable pageable , @PathVariable Long id  , Model model){

        List<Tag> Tags = TagService.listTagTop(10000);

        if(id == -1){
            id =Tags.get(0).getId();
        }

        model.addAttribute("tags", Tags);

        model.addAttribute("page", blogService.listBlog(id,pageable));

        model.addAttribute("activeTagId", id) ;

        return "tags";

    }

}
