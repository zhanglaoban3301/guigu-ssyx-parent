package com.atguigu.ssyx.acl.mapper;

import com.atguigu.ssyx.model.acl.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【admin_role(用户角色)】的数据库操作Mapper
* @createDate 2024-03-06 10:37:53
* @Entity generator.domain.AdminRole
*/
@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    @Delete("delete from admin_role where admin_id =#{adminId} ")
    void deleteAdminRoleByAdminId(Long adminId);
}




