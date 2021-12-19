package com.atduu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created  by DuuYuu on 2021/12/19 16:18
 **/
@Controller
public class AboutShowController {

    @GetMapping({"/","/about"})
    public String about(){
        return "about";
    }

}
