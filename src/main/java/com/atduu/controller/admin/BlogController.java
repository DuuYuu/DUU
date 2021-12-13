package com.atduu.controller.admin;

import com.atduu.pojo.Blog;
import com.atduu.pojo.Const;
import com.atduu.pojo.Type;
import com.atduu.pojo.User;
import com.atduu.service.BlogService;
import com.atduu.service.TagService;
import com.atduu.service.TypeService;
import com.atduu.vo.BlogQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    private static final String INPUT = "admin/blogs-input";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:admin/blogs";

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(@RequestParam(defaultValue = "1",value = "pageNum")int pageNum , BlogQuery blog , Model model){

        List<Type> types = typeService.selectAll();

        model.addAttribute("types",types);

        PageInfo<Blog> page = blogService.findBlogByPages(blog, pageNum, Const.PAGE_SIZE);

        model.addAttribute("page", page);

        return LIST;
    }


    @PostMapping("/blogs/search")
    public String search(@RequestParam(defaultValue = "1",value = "pageNum")int pageNum , BlogQuery blog , Model model){

        PageInfo<Blog> page = blogService.findBlogByPages(blog, pageNum, Const.PAGE_SIZE);

        model.addAttribute("page", page);

        return "admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){

        model.addAttribute("blog", new Blog());

        model.addAttribute("types",typeService.selectAll());

        model.addAttribute("tags",tagService.selectAll());

        return INPUT;
    }

    @PostMapping("/blogs")
    public String post(Blog blog , RedirectAttributes attributes, HttpSession session){

        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));

        int i = blogService.saveBlog(blog);

        if( i > 0 ){
            attributes.addFlashAttribute("message", "新增博客成功");
        }else {
            attributes.addFlashAttribute("message", "新增博客失败");
        }

        return REDIRECT_LIST;
    }

}
