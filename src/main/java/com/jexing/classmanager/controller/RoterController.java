package com.jexing.classmanager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
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

    @RequestMapping("stars")
    @RequiresRoles(value={"admin", "root"}, logical= Logical.OR)
    public String stars(){return "page/stars";}

    @RequestMapping("publish")
    @RequiresRoles(value={"admin", "root"}, logical= Logical.OR)
    public String publish(){return "page/publish";}

    @RequestMapping("userInfo")
    public String userInfo(){
        return "page/userInfo";
    }

    @RequestMapping("mystar")
    public String mystar(){ return "page/mystar" ;}

    @RequestMapping("comment")
    public String comment(){return "page/comment";}
    @RequestMapping("comment_child")
    public String comment_child(){return "page/commentChild";}

    @RequestMapping("rank_control")
    @RequiresRoles("root")
    public String rank_control(){return "page/rank";}

    @RequestMapping("commentDel")
    public String commentManagement(){return "page/commentManagement";}
}
