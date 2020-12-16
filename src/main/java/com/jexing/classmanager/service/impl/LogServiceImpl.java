package com.jexing.classmanager.service.impl;

import com.jexing.classmanager.dao.LogDao;
import com.jexing.classmanager.entity.Log;
import com.jexing.classmanager.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Log)表服务实现类
 *
 * @since 2020-12-09 12:49:53
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired

    private LogDao logDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Log queryById(Integer id) {
        return this.logDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Log log) {
        return   this.logDao.insert(log);

    }

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    @Override
    public Log update(Log log) {
        this.logDao.update(log);
        return this.queryById(log.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.logDao.deleteById(id) > 0;
    }

    @Override
    public List<Log> queryByUser(Integer id) {
        Log log = new Log();
        log.setToId(id);
        return logDao.queryAll(log);
    }

    @Override
    public List<Log> quertAll() {
        return logDao.queryAll(new Log());
    }
}
