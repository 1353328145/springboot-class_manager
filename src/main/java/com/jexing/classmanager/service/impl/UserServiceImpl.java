package com.jexing.classmanager.service.impl;

import com.jexing.classmanager.dao.UserDao;
import com.jexing.classmanager.entity.Log;
import com.jexing.classmanager.entity.User;
import com.jexing.classmanager.service.LogService;
import com.jexing.classmanager.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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

    @Autowired
    private LogService logService;
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
    public int update(User user) {
        return this.userDao.update(user);
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

    @Override
    public int updatePassword(User user) {
        user.setPassword(new Md5Hash(user.getPassword()).toHex());
        return userDao.update(user);
    }

    @Override
    public int queryCountByRank_id(Integer rank_id) {
        return userDao.queryCountByRank_id(rank_id);
    }

    @Override
    public List<User> queryByQuery(String query) {
        return userDao.queryByQuery(query);
    }

    @Override
    @Transactional(rollbackFor = { Exception.class })
    public boolean handleStar(String val,String info,Integer fromId,Integer toId) {
        Log log =new Log();
        char c = val.charAt(0);
        if (c!='-'&&c!='+'){
            return false;
        }
        log.setFlag(c=='+'?1:0);
        int value=0;
        for (int i = 1; i < val.length(); i++) {
            value=value*10+(val.charAt(i)-'0');
        }
        log.setVal(value);
        log.setCreateTime(new Date());
        log.setFromId(fromId);
        log.setInfo(info);
        log.setToId(toId);
        int insert = logService.insert(log);
        if (insert>0){
            int update;
            if (c=='+'){
                update = userDao.increaseStar(value,toId);
            }else{
                update = userDao.decreaseStar(value,toId);
            }
            if (update>0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
