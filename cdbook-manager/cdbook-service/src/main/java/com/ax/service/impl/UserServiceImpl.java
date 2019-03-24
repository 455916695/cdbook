package com.ax.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ax.entity.Result;
import com.ax.mapper.TbUserMapper;
import com.ax.pojo.TbUser;
import com.ax.pojo.TbUserExample;
import com.ax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private TbUserMapper userMapper;


    @Override
    public TbUser login(TbUser user) {
        if (user == null || StringUtils.isEmpty(user.getUsername()))
            return null;

        TbUser tbUser = userMapper.selectUserByUsername(user.getUsername());

        //  将输入的密码进行MD5加密，再与数据库中查询出来的数据进行比较
        if (tbUser != null && tbUser.getPassword().equals(user.getPassword())) {
            return tbUser;
        }
        return null;
    }

    @Override
    public Result Register(TbUser user) {
        Result result = null;
        if (user == null || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            result = new Result(false, "用户名和密码不能为空");
            return result;
        }
        //判断用户名是否存在
        TbUser tbUser = userMapper.selectUserByUsername(user.getUsername());
        if (tbUser == null || StringUtils.isEmpty(tbUser.getId())) {
            user.setId(UUID.randomUUID().toString());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            //  将输入的密码进行MD5加密,再存入数据库
            userMapper.insert(user);
            result = new Result(true, "注册成功", user);
            return result;
        } else {
            result = new Result(false, "用户名已存在");
            return result;
        }


    }
}
