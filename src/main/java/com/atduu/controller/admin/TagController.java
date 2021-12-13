package com.atduu.controller.admin;

import com.atduu.pojo.Const;
import com.atduu.pojo.Tag;
import com.atduu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created  by DuuYuu on 2021/12/13 15:09
 **/
@Controller
@RequestMapping("admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = Const.PAGE_SIZE , sort = {"id"} ,direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
        Page<Tag> page = tagService.findAllTagsByPages(pageable);

        model.addAttribute("page" , page);

        return "/admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(){
        return "/admin/tag-input";

    }

    @GetMapping("/tags/{id}/input")
    public  String editInput(@PathVariable Long id , Model model){

        model.addAttribute("tag", tagService.getTag(id));

        return "admin/tag-input";
    }

    @PostMapping("/tags/{id}/edit")
    public String type(Tag tag , @PathVariable Long id ,RedirectAttributes attributes,Model model){

        if(tagService.isExist(tag.getName())){

            model.addAttribute("message", "已有此标签");

            return "admin/tag-input";
        }

        if(id == -1){

            Tag t = tagService.saveTag(tag);

            if(t != null){
                attributes.addFlashAttribute("message", "新增成功");
            }else {
                attributes.addFlashAttribute("message", "新增失败");
            }
        }else {
            Tag t = tagService.updateTag(id , tag);

            if(t != null){
                attributes.addFlashAttribute("message", "更新成功");
            }else {
                attributes.addFlashAttribute("message", "更新失败");
            }
        }

        return "redirect:/admin/tags";
    }


    @GetMapping("/tags/{id}/delete")
    public String deleteType(@PathVariable Long id , RedirectAttributes attributes){

        tagService.deleteTag(id);

        return "redirect:/admin/tags";
    }





}
