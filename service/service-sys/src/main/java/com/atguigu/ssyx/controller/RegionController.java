package com.atguigu.ssyx.controller;

import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.sys.Region;
import com.atguigu.ssyx.service.RegionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("getRegion")
    private Result getRegion(){
        return Result.ok(null);
    }

    @GetMapping("getRegionByParentId")
    private Result getRegionByParentId(@RequestParam Long id){
        QueryWrapper<Region> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        List<Region> list = regionService.list(wrapper);
        return Result.ok(list);
    }
}
