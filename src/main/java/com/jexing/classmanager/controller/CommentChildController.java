package com.jexing.classmanager.controller;

import com.jexing.classmanager.entity.CommentChild;
import com.jexing.classmanager.service.CommentChildService;
import org.springframework.web.bind.annotation.GetMapping;
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
    /**
     * 服务对象
     */
    @Resource
    private CommentChildService commentChildService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommentChild selectOne(Integer id) {
        return this.commentChildService.queryById(id);
    }

}