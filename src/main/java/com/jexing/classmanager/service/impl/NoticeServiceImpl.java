package com.jexing.classmanager.service.impl;

import com.jexing.classmanager.dao.NoticeDao;
import com.jexing.classmanager.entity.Notice;
import com.jexing.classmanager.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @since 2020-12-09 12:49:54
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired

    private NoticeDao noticeDao;

    public List<Notice> queryBytheme(String query){
        return noticeDao.queryBytheme(query);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer id) {
        return this.noticeDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Notice notice) {
        if (notice.getUid()==null||notice.getContent()==null||notice.getTheme()==null){return -1;}
        notice.setCreateTime(new Date());
        System.out.println(notice);
        return this.noticeDao.insert(notice);
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeDao.update(notice);
        return this.queryById(notice.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.noticeDao.deleteById(id) > 0;
    }
}
