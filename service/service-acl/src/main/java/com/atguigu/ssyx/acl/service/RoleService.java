package com.atguigu.ssyx.acl.service;


import com.atguigu.ssyx.model.acl.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【role(角色)】的数据库操作Service
* @createDate 2024-03-04 15:47:32
*/
public interface RoleService extends IService<Role> {

    Long addRole(Role role);

    void upDateRplePermission(Long roleId, List<Long> permissionId);
}
