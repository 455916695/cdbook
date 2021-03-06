package com.ax.controller;

import com.ax.pojo.TbType;
import com.ax.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {

  @Autowired private TypeService typeService;

  @RequestMapping("/findAll")
  @ResponseBody
  public List<TbType> findAll() {

    List<TbType> all = null;
    try {
      all = typeService.findAll();
    } catch (Exception e) {
      e.getMessage();
    }
    return all;
  }
}
