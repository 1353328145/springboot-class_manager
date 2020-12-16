package com.jexing.classmanager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jexing.classmanager.entity.CommentChild;
import com.jexing.classmanager.entity.Log;
import com.jexing.classmanager.entity.Msg;
import com.jexing.classmanager.service.CommentChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("getByUser")
    public Map<String,Object> getByUser(Integer uid,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<CommentChild> logs =  commentChildService.queryByFromId(uid);
        PageInfo<CommentChild> info=new PageInfo<>(logs);
        Map<String,Object> map=new HashMap<>();
        map.put("data",info.getList());
        map.put("count",info.getTotal());
        map.put("msg","查询成功");
        map.put("code",0);
        return map;
    }

    @DeleteMapping("deleteById")
    public Msg deleteById(Integer id){
        if (id==null){return Msg.fail();}
        return commentChildService.deleteById(id)?Msg.success():Msg.fail();
    }
}
