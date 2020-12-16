package com.jexing.classmanager.service.impl;

import com.jexing.classmanager.dao.CommentChildDao;
import com.jexing.classmanager.dao.CommentDao;
import com.jexing.classmanager.entity.Comment;
import com.jexing.classmanager.entity.CommentChild;
import com.jexing.classmanager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @since 2020-12-09 12:49:51
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired

    private CommentDao commentDao;

    @Autowired
    private CommentChildDao commentChildDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Integer id) {
        return this.commentDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Comment comment) {
        comment.setCreateTime(new Date());
        return this.commentDao.insert(comment);
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        this.commentDao.update(comment);
        return this.queryById(comment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = { Exception.class })
    public boolean deleteById(Integer id) {
        return this.commentDao.deleteById(id) > 0 && commentChildDao.deleteByCid(id) > 0;
    }

    @Override
    public List<Comment> loadAll() {
        return commentDao.queryAllWithChild();
    }

    @Override
    public int getCount() {
        return commentDao.queryCount();
    }

    @Override
    public List<Comment> queryByFromId(Integer uid) {
        Comment comment = new Comment();
        comment.setFromId(uid);
        return this.commentDao.queryAll(comment);
    }
}
