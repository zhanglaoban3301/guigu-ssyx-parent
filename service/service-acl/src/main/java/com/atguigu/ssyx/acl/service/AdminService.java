package com.atguigu.ssyx.acl.service;


import com.atguigu.ssyx.model.acl.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【admin(用户表)】的数据库操作Service
* @createDate 2024-03-06 08:44:38
*/
public interface AdminService extends IService<Admin> {
    int addUser(Admin admin);
    List<Admin> getUsers();
}
