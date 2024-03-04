package com.atguigu.ssyx.acl.service;

import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.acl.LoginUser;

public interface LoginService {
    Result Login(String username, String password);
}
