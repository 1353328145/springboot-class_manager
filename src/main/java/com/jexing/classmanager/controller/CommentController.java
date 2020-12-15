package com.jexing.classmanager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jexing.classmanager.entity.Comment;
import com.jexing.classmanager.entity.Msg;
import com.jexing.classmanager.entity.Notice;
import com.jexing.classmanager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表控制层
 *
 * @since 2020-12-09 12:49:51
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Autowired
    private CommentService commentService;

    @GetMapping("loadAll")
    public Msg loadAll(Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<Comment> list = commentService.loadAll();
        PageInfo<Comment> info=new PageInfo<>(list);
        return Msg.success().add("data",info.getList()).add("count",info.getTotal());
    }

    @GetMapping("getCount")
    public Msg getCount(){
        int count = commentService.getCount();
        return Msg.success().add("count",count);
    }

    @PostMapping("add")
    public Msg add(Comment comment){
        if (comment.getContent()==null||comment.getFromId()==null){return Msg.fail();}
        return commentService.insert(comment)>0?Msg.success():Msg.fail();
    }
}
