package com.jexing.classmanager.service.impl;

import com.jexing.classmanager.dao.CommentChildDao;
import com.jexing.classmanager.entity.CommentChild;
import com.jexing.classmanager.service.CommentChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CommentChild)表服务实现类
 *
 * @since 2020-12-09 12:49:53
 */
@Service
public class CommentChildServiceImpl implements CommentChildService {
    @Autowired
    private CommentChildDao commentChildDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CommentChild queryById(Integer id) {
        return this.commentChildDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CommentChild> queryAllByLimit(int offset, int limit) {
        return this.commentChildDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param commentChild 实例对象
     * @return 实例对象
     */
    @Override
    public CommentChild insert(CommentChild commentChild) {
        this.commentChildDao.insert(commentChild);
        return commentChild;
    }

    /**
     * 修改数据
     *
     * @param commentChild 实例对象
     * @return 实例对象
     */
    @Override
    public CommentChild update(CommentChild commentChild) {
        this.commentChildDao.update(commentChild);
        return this.queryById(commentChild.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.commentChildDao.deleteById(id) > 0;
    }
}