package com.atduu.controller;

import com.atduu.Const.Const;
import com.atduu.pojo.Blog;
import com.atduu.service.BlogService;
import com.atduu.service.TagService;
import com.atduu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

        Page<Blog> blogs = blogService.listBlog(pageable);

        model.addAttribute("page", blogs);

        model.addAttribute("pageNumber", blogs.getNumber());

//        model.addAttribute("types", typeService.listTypeTop(Const.INDEX_TYPES_COUNT));

//        model.addAttribute("tags", tagService.listTagTop(Const.INDEX_TAGS_COUNT));

        //只有首页置顶文章
         if(blogs.getNumber()==0){
             model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(Const.INDEX_RECOMMEND_BLOG_COUNT));
         }

         return "index";

    }

//    @GetMapping("/blog")
//    public String Blog(@RequestParam Long id , Model model){
//
//        System.out.println("进入/blog里，id-----------"+id);
//
//        model.addAttribute("blog", blogService.getAndConvert(id));
//
//        return "blog";
//    }

    @GetMapping("/ablog")
    public String aBlog(@RequestParam Long id ,  @RequestParam String ques , Model model){

//        System.out.println("进入/blog里，id-----------"+id);

//        System.out.println(ques);

        if (!ques.equals("-1")){

            model.addAttribute("id", id);

            model.addAttribute("ques", ques);

            return "pwd";
        }else {

            model.addAttribute("blog", blogService.getAndConvert(id));

            return "blog";
        }
    }

    @PostMapping("/lockpwd")
    public String lockPwd(@RequestParam Long id , @RequestParam String ques , @RequestParam String ans , Model model ){

        Boolean aBoolean = blogService.checkPwd(id, ans);

        if (aBoolean){

//            System.out.println("答案正确");

            model.addAttribute("blog", blogService.getAndConvert(id));

            return "blog";

        }else {

            model.addAttribute("id", id);

            model.addAttribute("ques", ques);

            model.addAttribute("message", "答案不对啦(●'◡'●)");

            return "pwd";
        }

    }

    @RequestMapping("/search")
    public String search(@PageableDefault( size = Const.INDEX_PAGE_SIZE , sort = {"createTime"} ,
            direction = Sort.Direction.DESC) Pageable pageable , @RequestParam String query , Model model){

        model.addAttribute("page", blogService.listBlog("%"+query+"%", pageable));

        model.addAttribute("query", query);

        return "search";

    }

//    @GetMapping("/footer/newblog")
//    public String newblogs(Model model){
//
//        model.addAttribute("newblogs" , blogService.listRecommendBlogTop(3));
//
//        return "index :: newblogList";
//    }

}
