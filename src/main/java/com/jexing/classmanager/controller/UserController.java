package com.jexing.classmanager.controller;

import com.jexing.classmanager.entity.Msg;
import com.jexing.classmanager.entity.User;
import com.jexing.classmanager.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }


    /**
     * 登录
     */
    @PostMapping("login")
    public Msg login(User user) {
        String name = user.getName();
        String password = user.getPassword();
        if (name == null || password == null) {
            return Msg.fail("参数为空!");
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(name, password));
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail("密码错误!");
        }
        return Msg.success().add("uid", userService.queryIdByName(name));
    }
}