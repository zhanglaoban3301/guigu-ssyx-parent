package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.acl.mapper.AdminMapper;
import com.atguigu.ssyx.acl.service.LoginService;
import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.common.store.JavaStore;
import com.atguigu.ssyx.common.utils.JwtUtils;
import com.atguigu.ssyx.model.acl.Admin;
import com.atguigu.ssyx.model.acl.LoginUser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginServiceImpl extends ServiceImpl<AdminMapper, Admin> implements LoginService, UserDetailsService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Result Login(String username, String password) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authenticate = null;
        try{
            authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail("账号密码错误");
        }

        LoginUser principal = (LoginUser)authenticate.getPrincipal();
        redisTemplate.opsForValue().set(principal.getUsername(), principal);
        String token = JwtUtils.generateToken(principal.getUsername());
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return Result.ok(map);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Admin> adminMapperQuery = new QueryWrapper<>();
        Admin admin = adminMapper.selectOne(adminMapperQuery.eq("username",username));
        if(Objects.isNull(admin)){
            throw new RuntimeException("用户名密码错误");
        }
        List<String> list = Arrays.asList("admin");
        return new LoginUser(admin,list);
    }
}
