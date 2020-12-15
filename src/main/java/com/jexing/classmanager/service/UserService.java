package com.jexing.classmanager.service;

import com.jexing.classmanager.entity.Msg;
import com.jexing.classmanager.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @since 2020-12-09 12:49:55
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 用户名查用户
     * @param primaryPrincipal
     * @return
     */
    User getUserByName(String primaryPrincipal);

    /**
     * 用户名查id
     * @param name
     * @return
     */
    int queryIdByName(String name);

    int getCount();

    int updatePassword(User user);
}
