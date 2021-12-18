package com.atduu.controller.admin;

import com.atduu.Const.Const;
import com.atduu.pojo.Type;
import com.atduu.service.TypeService;
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
 * Created  by DuuYuu on 2021/12/12 17:01
 **/
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String tags(@PageableDefault(size = Const.PAGE_SIZE , sort = {"id"} ,direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
        Page<Type> page = typeService.findAllTypesByPages(pageable);

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
            Type t = typeService.saveType(type);

            if(t != null){
                attributes.addFlashAttribute("message", "新增成功");
            }else {
                attributes.addFlashAttribute("message", "新增失败");
            }
        }else {
            Type t = typeService.updateType(id, type);

            if(t != null ){
                attributes.addFlashAttribute("message", "更新成功");
            }else {
                attributes.addFlashAttribute("message", "更新失败");
            }
        }

        return "redirect:/admin/types";
    }


    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id ,RedirectAttributes attributes){

        typeService.deleteType(id);

        return "redirect:/admin/types";
    }

}
