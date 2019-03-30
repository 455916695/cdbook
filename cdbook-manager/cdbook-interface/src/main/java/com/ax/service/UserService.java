package com.ax.service;

import com.ax.entity.Result;
import com.ax.pojo.TbUser;

public interface UserService {

    /** 1.登录 */
    TbUser login(TbUser user);

    /** 2.注册 */
    Result Register(TbUser user);
}
