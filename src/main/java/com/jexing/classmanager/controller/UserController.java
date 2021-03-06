package com.jexing.classmanager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jexing.classmanager.entity.Msg;
import com.jexing.classmanager.entity.Notice;
import com.jexing.classmanager.entity.User;
import com.jexing.classmanager.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

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

    /**
     * 注册
     */
    @PostMapping("register")
    public Msg register(User user){
        int insert = userService.insert(user);
        return insert >0?Msg.success():Msg.fail();
    }

    /**
     * 用户名获取
     * @param id
     * @return
     */
    @GetMapping("getById/{id}")
    public Msg getById(@PathVariable("id") Integer id){
        User data = userService.queryById(id);
        return Msg.success().add("user", data);
    }


    @GetMapping("getCount")
    public Msg getCount(){
        return Msg.success().add("count",userService.getCount());
    }

    @GetMapping("getUserByQuery")
    public Msg getUserByQuery(String query){
        List<User> list = userService.queryByQuery(query);
        return Msg.success().add("users",list);
    }

    @PutMapping("updateInfo")
    public Msg updateInfo(User user){
        System.out.println(user);
        int update = userService.update(user);
        return update >0?Msg.success():Msg.fail();
    }

    @PutMapping("updatePassword")
    public Msg updatePassword(User user){
        return userService.updatePassword(user)>0?Msg.success():Msg.fail();
    }

    @PutMapping("updateStar")
    public Msg updateStar(String val,String info,Integer fromId,Integer toId){
        return userService.handleStar(val,info,fromId,toId)?Msg.success():Msg.fail();
    }

    @GetMapping("getUserByQueryPage")
    public Map<String,Object> getUserByQueryBlurry(String query,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<User> list = userService.queryByQuery(query);
        PageInfo<User> info=new PageInfo<>(list);
        Map<String,Object> map=new HashMap<>();
        map.put("data",info.getList());
        map.put("count",info.getTotal());
        map.put("msg","查询成功");
        map.put("code",0);
        return map;
    }

}
