package com.jexing.classmanager.service;

import com.jexing.classmanager.entity.CommentChild;

import java.util.List;

/**
 * (CommentChild)表服务接口
 *
 * @since 2020-12-09 12:49:53
 */
public interface CommentChildService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CommentChild queryById(Integer id);

    /**
     * 新增数据
     *
     * @param commentChild 实例对象
     * @return 实例对象
     */
    int insert(CommentChild commentChild);

    /**
     * 修改数据
     *
     * @param commentChild 实例对象
     * @return 实例对象
     */
    CommentChild update(CommentChild commentChild);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
