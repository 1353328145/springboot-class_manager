package com.jexing.classmanager;

import com.jexing.classmanager.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClassManagerApplicationTests {

    @Autowired
    private UserDao dao;
    @Test
    void contextLoads() {
        System.out.println(dao.queryByName("jexing"));
    }

}
