package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.acl.mapper.RolePermissionMapper;
import com.atguigu.ssyx.model.acl.RolePermission;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.acl.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【role_permission(角色权限)】的数据库操作Service实现
* @createDate 2024-03-05 14:13:00
*/
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
    implements RolePermissionService{
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int deleteRolePermissonByRoleId(Long roleId) {
        return rolePermissionMapper.deleteRolePermissonByRoleId(roleId);
    }

    @Override
    public List<RolePermission> getRolePermissionByRoleId(Long roleId) {
        return rolePermissionMapper.getRolePermissionByRoleId(roleId);
    }

    @Override
    public int addRolePermisson(RolePermission rolePermission) {
        return rolePermissionMapper.addRolePermisson(rolePermission);
    }
}




