package com.jexing.classmanager.dao;

import com.jexing.classmanager.entity.CommentChild;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (CommentChild)表数据库访问层
 *
 * @since 2020-12-09 12:49:53
 */
@Repository
public interface CommentChildDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CommentChild queryById(Integer id);

    /**
     * 通过父留言查
     */
    List<CommentChild> queryByCid(Integer cid);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param commentChild 实例对象
     * @return 对象列表
     */
    List<CommentChild> queryAll(CommentChild commentChild);

    /**
     * 新增数据
     *
     * @param commentChild 实例对象
     * @return 影响行数
     */
    int insert(CommentChild commentChild);

    /**
     * 修改数据
     *
     * @param commentChild 实例对象
     * @return 影响行数
     */
    int update(CommentChild commentChild);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int deleteByCid(Integer cid);
}
