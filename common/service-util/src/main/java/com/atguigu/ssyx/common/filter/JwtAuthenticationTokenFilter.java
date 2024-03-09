package com.atguigu.ssyx.common.filter;

import com.atguigu.ssyx.common.store.JavaStore;
import com.atguigu.ssyx.common.utils.JwtUtils;
import com.atguigu.ssyx.model.acl.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return;
        }
        //解析token
        String username;
        try{
            username = JwtUtils.getUsernameFromToken(token);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }

        //从map里查询用户是否处于登录状态
        LoginUser data =(LoginUser) redisTemplate.opsForValue().get(username);

        if(Objects.isNull(data)){
            throw new RuntimeException("用户未登录");
        }
        //TODO 查询对应的权限信息
        List<String> list = new ArrayList<String>();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(data, null, null);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request,response);
    }
}
