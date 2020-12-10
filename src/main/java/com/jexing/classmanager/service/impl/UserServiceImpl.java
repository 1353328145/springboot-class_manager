package com.jexing.classmanager.service.impl;

import com.jexing.classmanager.dao.UserDao;
import com.jexing.classmanager.entity.User;
import com.jexing.classmanager.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @since 2020-12-09 12:49:55
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(User user) {
        if (userDao.queryByName(user.getName())!=null){
            return -1;
        }
        user.setPassword(new Md5Hash(user.getPassword()).toHex());
        return this.userDao.insert(user);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public User getUserByName(String name) {
        return this.userDao.queryByName(name);
    }

    @Override
    public int queryIdByName(String name) {
        return userDao.queryIdByName(name);
    }

    @Override
    public int getCount() {
        return userDao.queryCount();
    }
}
