package com.jexing.classmanager.service;

import com.jexing.classmanager.entity.Log;

import java.util.List;

/**
 * (Log)表服务接口
 *
 * @since 2020-12-09 12:49:53
 */
public interface LogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Log queryById(Integer id);

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    int insert(Log log);

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log update(Log log);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Log> queryByUser(Integer id);

    List<Log> quertAll();
}
