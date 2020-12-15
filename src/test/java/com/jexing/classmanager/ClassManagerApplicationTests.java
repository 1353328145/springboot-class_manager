package com.jexing.classmanager;

import com.jexing.classmanager.dao.CommentChildDao;
import com.jexing.classmanager.dao.CommentDao;
import com.jexing.classmanager.dao.NoticeDao;
import com.jexing.classmanager.dao.UserDao;
import com.jexing.classmanager.entity.Comment;
import com.jexing.classmanager.entity.CommentChild;
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

    @Autowired
    private CommentChildDao commentChild;
    @Autowired
    private CommentDao commentDao;
    @Test
    void contextLoads() {
        List<Comment> list = commentDao.queryAllWithChild();
        for (Comment comment : list) {

        }
    }

}
