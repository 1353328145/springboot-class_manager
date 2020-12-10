package com.jexing.classmanager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoterController {
    @RequestMapping("main")
    public String main(){
        return "page/main";
    }

    @RequestMapping("notice")
    public String notice(){
        return "page/notice";
    }

    @RequestMapping("login")
    public String login(){return "login";}

    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
    @RequestMapping("register")
    public String register(){
        return "register";
    }
}
