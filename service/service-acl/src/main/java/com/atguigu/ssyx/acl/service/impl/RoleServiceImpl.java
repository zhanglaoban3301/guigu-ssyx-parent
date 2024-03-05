package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.acl.mapper.RolePermissionMapper;
import com.atguigu.ssyx.model.acl.Role;
import com.atguigu.ssyx.model.acl.RolePermission;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.ssyx.acl.service.RoleService;
import com.atguigu.ssyx.acl.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【role(角色)】的数据库操作Service实现
* @createDate 2024-03-04 15:47:32
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public Long addRole(Role role) {
        roleMapper.insert(role);
        return role.getId();
    }

    @Override
    public void upDateRplePermission(Long roleId, List<Long> permissionId) {
        rolePermissionMapper.deleteRolePermissonByRoleId(roleId);
        permissionId.forEach(item ->{
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermissionId(item);
            rolePermission.setRoleId(roleId);
            rolePermissionMapper.addRolePermisson(rolePermission);
        });
    }
}




