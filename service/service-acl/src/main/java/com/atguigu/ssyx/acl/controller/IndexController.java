package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.acl.service.LoginService;
import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.acl.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;

@Api(tags = "登录接口")
@RestController
@RequestMapping("/admin/acl/index")
public class IndexController {
    @Autowired
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        return loginService.Login(admin.getUsername(), admin.getPassword());
    }
    @ApiOperation("获取信息")
    @GetMapping("/info")
    public Result info(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","admin");
        map.put("roles", Arrays.asList("admin"));
        map.put("avatar","");
        map.put("introduction","");
        return Result.ok(map);
    }
    @ApiOperation("退出")
    @PostMapping("/logout")
    public Result logout(){
        return Result.ok(null);
    }
}
