package com.ax.service;

import com.ax.pojo.TbUser;

public interface UserService {

    /**
     * 1.登录
     */
    TbUser login(TbUser user);


    /**
     * 2.注册
     */
    void Register(TbUser user);

}
