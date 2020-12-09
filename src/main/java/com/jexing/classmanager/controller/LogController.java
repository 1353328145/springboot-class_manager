package com.jexing.classmanager.controller;

import com.jexing.classmanager.entity.Log;
import com.jexing.classmanager.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Log)表控制层
 *
 * @since 2020-12-09 12:49:54
 */
@RestController
@RequestMapping("log")
public class LogController {
    /**
     * 服务对象
     */
    @Resource
    private LogService logService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Log selectOne(Integer id) {
        return this.logService.queryById(id);
    }

}