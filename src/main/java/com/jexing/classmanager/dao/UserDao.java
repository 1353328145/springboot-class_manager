package com.jexing.classmanager.dao;

import com.jexing.classmanager.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @since 2020-12-09 12:49:55
 */
@Repository
public interface UserDao {

    User queryByName(String name);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 获取用户id
     */
    int queryIdByName(String name);

    /**
     * 用户id获取名字
     * @return
     */
    User queryNameById(Integer id);

    int queryCount();

    int queryCountByRank_id(Integer rank_id);

    List<User> queryByQuery(String query);


    int increaseStar(Integer val,Integer id);

    int decreaseStar(Integer val,Integer id);
}
