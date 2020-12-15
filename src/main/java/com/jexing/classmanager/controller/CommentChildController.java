package com.jexing.classmanager.controller;

import com.jexing.classmanager.entity.CommentChild;
import com.jexing.classmanager.entity.Msg;
import com.jexing.classmanager.service.CommentChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (CommentChild)表控制层
 *
 * @since 2020-12-09 12:49:53
 */
@RestController
@RequestMapping("commentChild")
public class CommentChildController {
    @Autowired
    private CommentChildService commentChildService;

    @PostMapping("add")
    public Msg add(CommentChild commentChild){
        if (commentChild.getCid()==null||commentChild.getContent()==null||commentChild.getToId()==null||commentChild.getToId()==null){return Msg.fail();}
        return commentChildService.insert(commentChild)>0?Msg.success():Msg.fail();
    }

}