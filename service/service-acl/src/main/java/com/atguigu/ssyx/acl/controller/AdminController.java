package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.acl.service.AdminRoleService;
import com.atguigu.ssyx.acl.service.AdminService;
import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.acl.Admin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户接口")
@RestController
@RequestMapping("/admin/acl/index")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRoleService adminRoleService;

    @GetMapping("getUsers")
    public Result getUsers(){
        List<Admin> list = adminService.getUsers();
        return Result.ok(list);
    }

    @GetMapping("getUserById")
    public Result getUserById(@RequestParam("id") Long id){
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        Admin admin = adminService.getOne(wrapper);
        return Result.ok(admin);
    }

    @PostMapping("addUser")
    public Result addUser(@RequestBody Admin admin){
        int i = adminService.addUser(admin);
        return Result.ok(i);
    }

    @PostMapping("updateUser")
    public Result updateUser(@RequestBody Admin admin){
        boolean save = adminService.updateById(admin);
        if(save){
            return Result.ok(null);
        }else{
            return Result.fail(null);
        }
    }
    @DeleteMapping("removeUsers")
    public Result removeUsers(@RequestBody List<Long> ids){
        boolean save = adminService.removeByIds(ids);
        if(save){
            return Result.ok(null);
        }else{
            return Result.fail(null);
        }
    }

    @PostMapping("updateUserRoles")
    public Result updateUserRoles(@RequestBody Admin admin){
        try {
            adminRoleService.updateAdminRole(admin);
            return Result.ok(null);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(null);
        }
    }
}
