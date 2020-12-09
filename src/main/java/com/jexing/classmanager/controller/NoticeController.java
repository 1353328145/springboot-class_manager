package com.jexing.classmanager.controller;

import com.jexing.classmanager.entity.Notice;
import com.jexing.classmanager.service.NoticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Notice)表控制层
 *
 * @since 2020-12-09 12:49:54
 */
@RestController
@RequestMapping("notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Notice selectOne(Integer id) {
        return this.noticeService.queryById(id);
    }

}