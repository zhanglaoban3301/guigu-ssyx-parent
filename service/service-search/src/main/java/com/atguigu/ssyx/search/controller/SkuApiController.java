package com.atguigu.ssyx.search.controller;

import com.atguigu.ssyx.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/search/sku")
public class SkuApiController {
    @GetMapping("inner/upperSku/${skuId}")
    public Result upperSku(@PathVariable Long skuId){
        return Result.ok(null);
    }

    @GetMapping("inner/lowerSku/${skuId}")
    public Result lowerSku(@PathVariable Long skuId){
        return Result.ok(null);
    }
}
