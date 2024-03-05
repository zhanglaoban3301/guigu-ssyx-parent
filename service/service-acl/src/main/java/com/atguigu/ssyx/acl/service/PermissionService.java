package com.atguigu.ssyx.acl.service;


import com.atguigu.ssyx.model.acl.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【permission(权限)】的数据库操作Service
* @createDate 2024-03-04 16:57:42
*/
public interface PermissionService extends IService<Permission> {
    List<Map<String,Object>> getRoutes();
}
