package com.atduu.controller.admin;

import com.atduu.pojo.Blog;
import com.atduu.Const.Const;
import com.atduu.pojo.Type;
import com.atduu.pojo.User;
import com.atduu.service.BlogService;
import com.atduu.service.TagService;
import com.atduu.service.TypeService;
import com.atduu.vo.BlogQuery;
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

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author DuuYuu
 * @Date 2021/12/12 15:19
 **/
@Controller
@RequestMapping("/admin")
public class BlogController {

    private static final String INPUT = "/admin/blogs-input";
    private static final String LIST = "/admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = Const.PAGE_SIZE , sort = {"updateTime"} ,
                        direction = Sort.Direction.DESC) Pageable pageable ,
                        BlogQuery blog, Model model,HttpSession session){

        List<Type> types = typeService.selectAll();

        model.addAttribute("types", types);

        Page<Blog> page = blogService.listBlog(pageable, blog);

        model.addAttribute("page", page);

        Object user = session.getAttribute("user");

        model.addAttribute("user", user);

        return LIST;
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = Const.PAGE_SIZE , sort = {"updateTime"} ,
            direction = Sort.Direction.DESC) Pageable pageable ,
                         BlogQuery blog, Model model){

        Page<Blog> page = blogService.listBlog(pageable, blog);

        model.addAttribute("page", page);

        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/{id}/input")
    public String input(@PathVariable Long id , Model model){

        model.addAttribute("types",typeService.selectAll());

        model.addAttribute("tags",tagService.selectAll());

        if(id == -1){

            model.addAttribute("blog", new Blog());

        }else {
            Blog blog = blogService.getBlogById(id);

            blog.init();

            model.addAttribute("blog", blog);
        }

        System.out.println();

        return INPUT;
    }

    @PostMapping("/blogs")
    public String post(Blog blog , RedirectAttributes attributes, HttpSession session){

        blog.setUser((User) session.getAttribute("user"));

        blog.setType(typeService.getType(blog.getType().getId()));

        blog.setTags(tagService.listTag(blog.getTagIds()));

        Blog b;

        //如果id不为空则更新文章  如果为空则创建文章
        if(blog.getId() == null){
            b = blogService.saveBlog(blog);
        }else {
            b = blogService.updateBlog(blog.getId(), blog);
        }

        if( b != null ){
            attributes.addFlashAttribute("message", "操作成功");
        }else {
            attributes.addFlashAttribute("message", "操作失败");
        }

        return REDIRECT_LIST;
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete (@PathVariable Long id ){

        blogService.deleteBlog(id);

        return REDIRECT_LIST;
    }

}
