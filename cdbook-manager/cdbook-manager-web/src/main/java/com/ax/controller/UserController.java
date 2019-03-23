package com.ax.controller;

import com.ax.pojo.TbUser;
import com.ax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 登陆
     */
    @RequestMapping("/login")
    @ResponseBody
    public void login(TbUser user) {
        // TODO 登陆
    }

    /**
     * 注册
     */
    @RequestMapping("/register")
    @ResponseBody
    public void Register(TbUser user) {
        // TODO 注册
    }



}

