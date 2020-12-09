package com.jexing.classmanager.dao;

import com.jexing.classmanager.entity.Rank;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Rank)表数据库访问层
 *
 * @since 2020-12-09 12:49:54
 */
@Repository

public interface RankDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rank queryById(Integer id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rank 实例对象
     * @return 对象列表
     */
    List<Rank> queryAll(Rank rank);

    /**
     * 新增数据
     *
     * @param rank 实例对象
     * @return 影响行数
     */
    int insert(Rank rank);

    /**
     * 修改数据
     *
     * @param rank 实例对象
     * @return 影响行数
     */
    int update(Rank rank);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}