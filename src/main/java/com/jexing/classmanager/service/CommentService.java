package com.jexing.classmanager.service;

import com.jexing.classmanager.entity.Comment;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @since 2020-12-09 12:49:48
 */
public interface CommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Comment queryById(Integer id);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    int insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Comment> loadAll();

    int getCount();

    List<Comment> queryByFromId(Integer uid);
}
