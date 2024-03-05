package com.atguigu.ssyx.acl.mapper;

import com.atguigu.ssyx.model.acl.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【role_permission(角色权限)】的数据库操作Mapper
 * @createDate 2024-03-05 14:13:00
 * @Entity generator.domain.RolePermission
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    @Delete("delete from role_permission where role_id = #{roleId} ")
    int deleteRolePermissonByRoleId(Long roleId);

    @Select("select * from role_permission where role_id=#{roleId}}")
    List<RolePermission> getRolePermissionByRoleId(Long roleId);

    @Insert("insert into role_permission(role_id,permission_id,is_deleted) " +
            "values(#{roleId},#{permissionId},'0')")
    int addRolePermisson(RolePermission rolePermission);
}
