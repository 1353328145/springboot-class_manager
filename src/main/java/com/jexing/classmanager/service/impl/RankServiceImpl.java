package com.jexing.classmanager.service.impl;

import com.jexing.classmanager.dao.RankDao;
import com.jexing.classmanager.entity.Rank;
import com.jexing.classmanager.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Rank)表服务实现类
 *
 * @since 2020-12-09 12:49:55
 */
@Service
public class RankServiceImpl implements RankService {
    @Autowired

    private RankDao rankDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Rank queryById(Integer id) {
        return this.rankDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param rank 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Rank rank) {
        return  this.rankDao.insert(rank);
    }

    /**
     * 修改数据
     *
     * @param rank 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Rank rank) {
        return  this.rankDao.update(rank);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.rankDao.deleteById(id) > 0;
    }

    @Override
    public List<Rank> queryAll() {
        return rankDao.queryAll(new Rank());
    }
}