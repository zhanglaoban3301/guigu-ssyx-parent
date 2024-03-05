package com.atguigu.ssyx.acl.service;

import com.atguigu.ssyx.model.acl.RolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Administrator
* @description 针对表【role_permission(角色权限)】的数据库操作Service
* @createDate 2024-03-05 14:13:00
*/

public interface RolePermissionService extends IService<RolePermission> {

    int deleteRolePermissonByRoleId(Long roleId);

    List<RolePermission> getRolePermissionByRoleId(Long roleId);

    int addRolePermisson(RolePermission rolePermission);
}
