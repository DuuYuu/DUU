package com.atduu.controller;

import com.atduu.Const.Const;
import com.atduu.pojo.Type;
import com.atduu.service.BlogService;
import com.atduu.service.TypeService;
import com.atduu.vo.BlogQuery;
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
public class TypeShowController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService ;

    @GetMapping("/types/{id}")
    public String types(@PageableDefault( size = Const.INDEX_PAGE_SIZE , sort = {"updateTime"} ,
            direction = Sort.Direction.ASC) Pageable pageable , @PathVariable Long id  , Model model){

        List<Type> types = typeService.listTypeTop(10000);

        if(id == -1){
            id =types.get(0).getId();
        }

        model.addAttribute("types", types);

        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);

        model.addAttribute("page", blogService.listBlog(pageable,blogQuery));

        model.addAttribute("activeTypeId", id) ;

        return "types";

    }

}
