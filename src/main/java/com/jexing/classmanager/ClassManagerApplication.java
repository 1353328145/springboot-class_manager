package com.jexing.classmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.jexing.classmanager.dao")
@EnableTransactionManagement
public class ClassManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClassManagerApplication.class, args);
    }
}
