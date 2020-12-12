package com.jexing.classmanager;

import com.jexing.classmanager.dao.NoticeDao;
import com.jexing.classmanager.dao.UserDao;
import com.jexing.classmanager.entity.Notice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ClassManagerApplicationTests {

    @Autowired
    private UserDao dao;

    @Autowired
    private NoticeDao noticeDao;
    @Test
    void contextLoads() { }

}
