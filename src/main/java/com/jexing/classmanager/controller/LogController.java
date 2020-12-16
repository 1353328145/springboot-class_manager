package com.jexing.classmanager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jexing.classmanager.entity.Log;
import com.jexing.classmanager.entity.Msg;
import com.jexing.classmanager.entity.Notice;
import com.jexing.classmanager.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Log)表控制层
 *
 * @since 2020-12-09 12:49:54
 */
@RestController
@RequestMapping("log")
public class LogController {
    /**
     * 服务对象
     */
    @Resource
    private LogService logService;

    @GetMapping("getLogByUser/{id}")
    public Map<String, Object> getLogByUser(@PathVariable("id") Integer id, Integer page, Integer limit){
        PageHelper.startPage(page,limit);
        List<Log> logs =  logService.queryByUser(id);
        PageInfo<Log> info=new PageInfo<>(logs);
        Map<String,Object> map=new HashMap<>();
        map.put("data",info.getList());
        map.put("count",info.getTotal());
        map.put("msg","查询成功");
        map.put("code",0);
        return map;
    }
    @GetMapping("getAllLog")
    public Map<String, Object> getAllLog(Integer page, Integer limit){
        PageHelper.startPage(page,limit);
        List<Log> logs =  logService.quertAll();
        PageInfo<Log> info=new PageInfo<>(logs);
        Map<String,Object> map=new HashMap<>();
        map.put("data",info.getList());
        map.put("count",info.getTotal());
        map.put("msg","查询成功");
        map.put("code",0);
        return map;
    }

}
