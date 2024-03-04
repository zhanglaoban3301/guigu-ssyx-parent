package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.acl.service.RoleService;
import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.acl.Role;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色接口")
@RestController
@RequestMapping("/admin/acl")
public class RoleController {
    @Autowired
    private RoleService roleService;
    //角色列表
    @ApiOperation("查询角色列表")
    @GetMapping("roles")
    public Result roles(@RequestParam(required = false) String roleName){
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(roleName)){
            roleQueryWrapper.eq("role_name",roleName);
        }
        List<Role> list = roleService.list(roleQueryWrapper);
        return Result.ok(list);
    }


    //添加角色
    @ApiOperation("添加角色")
    @PostMapping("role")
    public Result addRole(@RequestBody Role role){
        boolean save = roleService.save(role);
        if(save){
            return Result.ok(null);
        }else{
            return Result.fail(null);
        }
    }
    //根据id修改角色
    @ApiOperation("修改角色")
    @PostMapping("updateRole")
    public Result updateRole(@RequestBody Role role){
        boolean save = roleService.updateById(role);
        if(save){
            return Result.ok(null);
        }else{
            return Result.fail(null);
        }
    }
    //批量删除角色
    @ApiOperation("批量删除角色")
    @DeleteMapping("deleteRoles")
    public Result deleteRoles(@RequestBody List<Long> idList){
        boolean ok = roleService.removeByIds(idList);
        if(ok){
            return Result.ok(null);
        }else {
            return Result.fail(null);
        }
    }
}
