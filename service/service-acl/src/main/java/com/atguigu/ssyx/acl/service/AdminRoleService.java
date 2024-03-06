package com.atguigu.ssyx.acl.service;


import com.atguigu.ssyx.model.acl.Admin;
import com.atguigu.ssyx.model.acl.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【admin_role(用户角色)】的数据库操作Service
* @createDate 2024-03-06 10:37:53
*/
public interface AdminRoleService extends IService<AdminRole> {
    void updateAdminRole(Admin admin);
}
