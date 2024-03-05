package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.acl.mapper.RolePermissionMapper;
import com.atguigu.ssyx.model.acl.Permission;
import com.atguigu.ssyx.model.acl.RolePermission;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.atguigu.ssyx.acl.service.PermissionService;
import com.atguigu.ssyx.acl.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* @author Administrator
* @description 针对表【permission(权限)】的数据库操作Service实现
* @createDate 2024-03-04 16:57:42
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    private List<Permission> permissions;
    @Override
    public List<Map<String,Object>> getRoutes() {
        List<Map<String, Object>> list = new ArrayList<>();
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.eq("type","1");
        wrapper.ne("path","/");
        //获取所有菜单
        permissions = permissionMapper.selectList(wrapper);
        //第一级菜单
        List<Permission> rootMenus = permissions.stream().filter(menu -> menu.getPid() == 1).collect(Collectors.toList());
        rootMenus.forEach(rootMenu -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", rootMenu.getId());
            map.put("path", rootMenu.getPath());
            map.put("component", true);
            map.put("redirect", "/" + rootMenu.getPath());
            map.put("name", rootMenu.getCode());
            map.put("meta", retMeta(rootMenu));
            map.put("children", getChildrens(rootMenu.getId(),rootMenu.getPath()));
            list.add(map);
        });
        return list;
    }

    private List<Map<String, Object>> getChildrens(Long parentId,String path) {
        List<Map<String, Object>> children = new ArrayList<>();
        List<Permission> childMenus = permissions.stream().filter(menu -> menu.getPid().equals(parentId)).collect(Collectors.toList());
        childMenus.forEach(childMenu -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", childMenu.getId());
            map.put("path", childMenu.getPath());
            map.put("component", true);
            map.put("redirect",path+ "/" + childMenu.getPath());
            map.put("name", childMenu.getCode());
            map.put("meta", retMeta(childMenu));
            map.put("children", getChildrens(childMenu.getId(),childMenu.getPath()));
            children.add(map);
        });
        return children;
    }

    private HashMap<String, Object> retMeta(Permission menu) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title",menu.getName());
        map.put("icon",menu.getIcon());
        map.put("roles",getRolesByPermissionId(menu.getId()));
        return map;
    }

    private List<Long> getRolesByPermissionId(Long id) {
        QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
        wrapper.eq("permission_id",id);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectList(wrapper);
        return rolePermissions.stream().map(RolePermission::getRoleId).collect(Collectors.toList());
    }
}




