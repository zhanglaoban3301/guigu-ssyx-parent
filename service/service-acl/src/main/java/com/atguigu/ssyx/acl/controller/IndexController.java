package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Api("登录接口")
@RestController
@RequestMapping("/admin/acl/index")
public class IndexController {
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(){
        HashMap<String, String> map = new HashMap<>();
        map.put("token","token-admin");
        return Result.ok(map);
    }
    @ApiOperation("获取信息")
    @GetMapping("/info")
    public Result info(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name","admin");
        map.put("avatar","");
        return Result.ok(map);
    }
    @ApiOperation("退出")
    @PostMapping("/logout")
    public Result logout(){
        return Result.ok(null);
    }
}
