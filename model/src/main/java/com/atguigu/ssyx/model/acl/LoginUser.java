package com.atguigu.ssyx.model.acl;

import com.atguigu.ssyx.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@ApiModel(description = "用户")
@TableName("admin")
public class LoginUser extends BaseEntity implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;
    private List<String> permissions;
    private Admin admin;
    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;
    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;
    @ApiModelProperty(value = "角色名称")
    @TableField(exist = false)
    private String roleName;

    public LoginUser(Admin admin,List<String> permissions){
        this.admin = admin;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roleList = new ArrayList<>();
        permissions.forEach(v->{
            roleList.add(new SimpleGrantedAuthority(v));
        });
        return roleList;
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
