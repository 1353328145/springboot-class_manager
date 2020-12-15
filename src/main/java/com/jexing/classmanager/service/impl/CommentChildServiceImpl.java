package com.jexing.classmanager.service.impl;

import com.jexing.classmanager.dao.CommentChildDao;
import com.jexing.classmanager.entity.CommentChild;
import com.jexing.classmanager.service.CommentChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
