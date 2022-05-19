package com.atduu.controller.admin;

import com.atduu.pojo.User;
import com.atduu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping()
   public String loginPage(){
       return "admin/login";
   }

   @PostMapping("/login")
   public String login(@RequestParam String username , @RequestParam String password, HttpSession session, RedirectAttributes attributes, Model model){

       User user = userService.checkUser(username, password);

       if(user != null){

//           System.out.println("登录成功");

           user.setPassword(null);

           session.setAttribute("user", user);

           return "admin/index";
       }else {

//           System.out.println("用户名和密码错误");

           attributes.addFlashAttribute("message", "用户名或密码错误");

           return "redirect:/admin";
       }

   }

   @GetMapping("/logout")
   public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
   }

}