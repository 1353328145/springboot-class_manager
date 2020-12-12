package com.jexing.classmanager.service;

import com.jexing.classmanager.entity.Notice;

import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @since 2020-12-09 12:49:54
 */
public interface NoticeService {


    /**
     * 通过主题查询数据
     * @param query
     * @return
     */
    List<Notice> queryBytheme(String query);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Notice queryById(Integer id);


    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    int insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
