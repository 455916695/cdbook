package com.ax.service;

import com.ax.pojo.TbType;

import java.util.List;

public interface TypeService {

  /** 1.查询所有分类 */
  List<TbType> findAll();
}
