package com.atduu.controller.admin;

import com.atduu.pojo.Const;
import com.atduu.pojo.Type;
import com.atduu.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created  by DuuYuu on 2021/12/12 17:01
 **/
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@RequestParam(defaultValue = "1",value = "pageNum") int pageNum, Model model){

        PageInfo<Type> page = typeService.findAllTypesByPages(pageNum, Const.PAGE_SIZE);

        model.addAttribute("page" , page);

        return "/admin/types";
    }

    @GetMapping("/types/input")
    public String input(){
        return "/admin/type-input";

    }

    @GetMapping("/types/{id}/input")
    public  String editInput(@PathVariable Long id , Model model){

        model.addAttribute("type", typeService.getType(id));

        return "admin/type-input";
    }

    @PostMapping("/types/{id}/edit")
    public String type(Type type , @PathVariable Long id ,RedirectAttributes attributes,Model model){

        if(typeService.isExist(type.getName())){

            model.addAttribute("message", "已有此分类");

            return "admin/type-input";
        }

        if(id == -1){
            int i = typeService.saveType(type);

            if(i > 0){
                attributes.addFlashAttribute("message", "新增成功");
            }else {
                attributes.addFlashAttribute("message", "新增失败");
            }
        }else {
            int i = typeService.updateType(id, type);

            if(i > 0){
                attributes.addFlashAttribute("message", "更新成功");
            }else {
                attributes.addFlashAttribute("message", "更新失败");
            }
        }

        return "redirect:/admin/types";
    }


    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id ,RedirectAttributes attributes){

        int i = typeService.deleteType(id);

        if(i > 0){
            attributes.addFlashAttribute("message", "删除成功");
        }else {
            attributes.addFlashAttribute("message", "删除失败");
        }

        return "redirect:/admin/types";
    }

}
