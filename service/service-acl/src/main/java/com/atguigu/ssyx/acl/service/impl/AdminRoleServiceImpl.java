package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.model.acl.Admin;
import com.atguigu.ssyx.model.acl.AdminRole;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.ssyx.acl.service.AdminRoleService;
import com.atguigu.ssyx.acl.mapper.AdminRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【admin_role(用户角色)】的数据库操作Service实现
* @createDate 2024-03-06 10:37:53
*/
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole>
    implements AdminRoleService{
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Override
    public void updateAdminRole(Admin admin) {
        Long adminId = admin.getId();
        QueryWrapper<AdminRole> adminRoleWrapper = new QueryWrapper<>();
        adminRoleWrapper.eq("admin_id",adminId);
        //删除adminId的角色
        adminRoleMapper.deleteAdminRoleByAdminId(adminId);
        admin.getRoleIds().forEach(roleId->{
            AdminRole adminRole = new AdminRole();
            adminRole.setAdminId(adminId);
            adminRole.setRoleId(roleId);
            int insert = adminRoleMapper.insert(adminRole);
        });
    }
}




