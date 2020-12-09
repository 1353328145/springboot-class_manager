package com.jexing.classmanager.service;

import com.jexing.classmanager.entity.Rank;

import java.util.List;

/**
 * (Rank)表服务接口
 *
 * @since 2020-12-09 12:49:55
 */
public interface RankService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rank queryById(Integer id);

    /**
     * 新增数据
     *
     * @param rank 实例对象
     * @return 实例对象
     */
    Rank insert(Rank rank);

    /**
     * 修改数据
     *
     * @param rank 实例对象
     * @return 实例对象
     */
    Rank update(Rank rank);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}