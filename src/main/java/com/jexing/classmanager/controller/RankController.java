package com.jexing.classmanager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jexing.classmanager.entity.Msg;
import com.jexing.classmanager.entity.Notice;
import com.jexing.classmanager.entity.Rank;
import com.jexing.classmanager.service.RankService;
import com.jexing.classmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Rank)表控制层
 *
 * @since 2020-12-09 12:49:55
 */
@RestController
@RequestMapping("rank")
public class RankController {
    /**
     * 服务对象
     */
    @Autowired
    private RankService rankService;
    @Autowired
    private UserService userService;

    @GetMapping("loadAllByPage")
    public Map<String,Object> load(Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<Rank> list =  rankService.queryAll();
        PageInfo<Rank> info=new PageInfo<>(list);
        Map<String,Object> map=new HashMap<>();
        map.put("data",info.getList());
        map.put("count",info.getTotal());
        map.put("msg","查询成功");
        map.put("code",0);
        return map;
    }
    @GetMapping("loadAll")
    public Msg load(){
        List<Rank> list =  rankService.queryAll();
        return Msg.success().add("ranks",list);
    }
    @PostMapping("add")
    public Msg add(Rank rank){
        if (rank.getInfo()==null){
            return Msg.fail();
        }
        return rankService.insert(rank)>0?Msg.success():Msg.fail();
    }

    @DeleteMapping("deleteById")
    public Msg deleteById(Integer id){
        int size = userService.queryCountByRank_id(id);
        if (size!=0){
            return Msg.fail();
        }
        return rankService.deleteById(id)?Msg.success():Msg.fail();
    }

    @PutMapping("update")
    public Msg update(Rank rank){
        int update = rankService.update(rank);
        return update>0?Msg.success():Msg.fail();
    }
}