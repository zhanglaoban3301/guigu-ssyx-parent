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

@Api("菜单权限")
@RestController
@RequestMapping("/admin/acl")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    //角色列表
    @ApiOperation("查询角色列表")
    @GetMapping("routes")
    public Result routes(){
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.eq("type","1");
        List<Permission> list = permissionService.list(wrapper);
        return Result.ok(list);
    }
}
