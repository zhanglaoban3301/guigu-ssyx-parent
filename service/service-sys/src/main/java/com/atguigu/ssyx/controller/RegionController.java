package com.atguigu.ssyx.controller;

import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.sys.Region;
import com.atguigu.ssyx.model.sys.RegionWare;
import com.atguigu.ssyx.service.RegionService;
import com.atguigu.ssyx.service.RegionWareService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/region")
public class RegionController {
    @Autowired
    private RegionService regionService;
    @Autowired
    private RegionWareService regionWareService;


    @GetMapping("getRegion")
    private Result getRegion(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize){
        List<RegionWare> region = regionService.getRegion(pageNo, pageSize);
        return Result.ok(region);
    }
    @GetMapping("getRegionCount")
    private Result getRegionCount(){
        int count = regionWareService.count();
        return Result.ok(count);
    }
    @GetMapping("getRegionByParentId")
    private Result getRegionByParentId(@RequestParam Long id){
        QueryWrapper<Region> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        List<Region> list = regionService.list(wrapper);
        return Result.ok(list);
    }

    @PostMapping("addRegion")
    private Result addRegion(@RequestBody RegionWare regionWare){
        try{
            regionService.addRegion(regionWare);
            return Result.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(null);
        }
    }
    @PostMapping("updateStatus")
    private Result updateStatus(@RequestParam("id") Long id,@RequestParam("status") int status){
        try{
            regionWareService.updateStatus(status,id);
            return Result.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(null);
        }
    }
    @DeleteMapping("removeRegionWare")
    private Result removeRegionWare(@RequestBody List<Long> ids){
        return Result.ok(regionWareService.removeByIds(ids));
    }
}
