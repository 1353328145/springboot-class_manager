package com.jexing.classmanager.controller;

import com.jexing.classmanager.entity.Rank;
import com.jexing.classmanager.service.RankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Rank)表控制层
 *
 * @since 2020-12-09 12:49:55
 */
@RestController
@RequestMapping("rank")
public class RankController {
    /**
     * 服务对象
     */
    @Resource
    private RankService rankService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Rank selectOne(Integer id) {
        return this.rankService.queryById(id);
    }

}