package com.jexing.classmanager.controller;

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
}
