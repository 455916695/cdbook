package com.ax.controller;

import com.alibaba.druid.util.StringUtils;
import com.ax.entity.Result;
import com.ax.pojo.TbUser;
import com.ax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired private UserService userService;

  /** 登陆 */
  @RequestMapping("/login")
  @ResponseBody
  public Result login(TbUser user, HttpServletRequest request) {
    // TODO 登陆
    Result result = null;

    try {
      user = userService.login(user); // 如果登录成功返回 含有Id 的User
    } catch (Exception e) {
      e.printStackTrace();
      result = new Result(false, "登录失败：" + e.getMessage());
    }

    if (user != null && !StringUtils.isEmpty(user.getId())) {
      request.getSession().setAttribute("user", user);
      result = new Result(true, "登录成功", user);
    } else {
      result = new Result(false, "登录失败:用户名或密码错误");
    }

    return result;
  }

  /** 注册 */
  @RequestMapping("/register")
  @ResponseBody
  public Result Register(TbUser user) {
    Result result = null;
    try {
      result = userService.Register(user);
    } catch (Exception e) {
      e.printStackTrace();
      result = new Result(false, "注册失败：" + e.getMessage());
    }
    // TODO 注册

    return result;
  }
}
