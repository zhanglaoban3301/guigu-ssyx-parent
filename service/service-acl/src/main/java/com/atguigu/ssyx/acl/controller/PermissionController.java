package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.acl.service.PermissionService;
import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.acl.Permission;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "菜单权限")
@RestController
@RequestMapping("/admin/acl")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    //角色列表
    @ApiOperation("查询菜单列表")
    @GetMapping("routes")
    public Result routes(){
        List<Map<String, Object>> routes = permissionService.getRoutes();
        return Result.ok(routes);
    }


}
