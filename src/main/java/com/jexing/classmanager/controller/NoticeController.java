package com.jexing.classmanager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jexing.classmanager.entity.Msg;
import com.jexing.classmanager.entity.Notice;
import com.jexing.classmanager.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    @PostMapping("save")
    public Msg save(Notice notice){
        int insert = noticeService.insert(notice);
        return insert >0?Msg.success():Msg.fail();
    }

    @GetMapping("load")
    public Map loadAll(String query,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<Notice> notices = noticeService.queryBytheme(query);
        PageInfo<Notice> info=new PageInfo<>(notices);
        Map<String,Object> map=new HashMap<>();
        map.put("data",info.getList());
        map.put("count",info.getTotal());
        map.put("msg","查询成功");
        map.put("code",0);
        return map;
    }

    @PutMapping("update")
    public Msg update(Notice notice){
        int update = noticeService.update(notice);
        return update >0?Msg.success():Msg.fail();
    }

    @GetMapping("getCount")
    public Msg getCount(){
        return Msg.success().add("count",noticeService.queryCount());
    }

    @DeleteMapping("delete")
    public Msg delete(Notice notice){
        if (notice.getId()==null){
            return Msg.fail();
        }
        return noticeService.deleteById(notice.getId())?Msg.success():Msg.fail();
    }
}
