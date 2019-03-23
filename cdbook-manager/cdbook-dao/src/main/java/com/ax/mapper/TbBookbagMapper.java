package com.ax.mapper;

import com.ax.pojo.TbBookbag;
import com.ax.pojo.TbBookbagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBookbagMapper {
    int countByExample(TbBookbagExample example);

    int deleteByExample(TbBookbagExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbBookbag record);

    int insertSelective(TbBookbag record);

    List<TbBookbag> selectByExample(TbBookbagExample example);

    TbBookbag selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbBookbag record, @Param("example") TbBookbagExample example);

    int updateByExample(@Param("record") TbBookbag record, @Param("example") TbBookbagExample example);

    int updateByPrimaryKeySelective(TbBookbag record);

    int updateByPrimaryKey(TbBookbag record);
}