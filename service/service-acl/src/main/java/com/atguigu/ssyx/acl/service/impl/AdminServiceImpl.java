package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.acl.mapper.AdminMapper;
import com.atguigu.ssyx.acl.mapper.AdminRoleMapper;
import com.atguigu.ssyx.model.acl.Admin;
import com.atguigu.ssyx.model.acl.AdminRole;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.ssyx.acl.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【admin(用户表)】的数据库操作Service实现
* @createDate 2024-03-06 08:44:38
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Override
    public int addUser(Admin admin) {
        int insert = adminMapper.insert(admin);
        return insert;
    }

    @Override
    public List<Admin> getUsers() {
        List<Admin> admins = adminMapper.selectList(null);
        for(Admin admin : admins){
            Long adminId = admin.getId();
            QueryWrapper<AdminRole> wrapper = new QueryWrapper<>();
            wrapper.eq("admin_id",adminId);
            List<Long> roleIds = adminRoleMapper.selectList(wrapper).stream().map(AdminRole::getRoleId).collect(Collectors.toList());
            admin.setRoleIds(roleIds);
        }
        return admins;
    }


}




