package com.ax.mapper;

import com.ax.pojo.TbBookcase;
import com.ax.pojo.TbBookcaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBookcaseMapper {
    int countByExample(TbBookcaseExample example);

    int deleteByExample(TbBookcaseExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbBookcase record);

    int insertSelective(TbBookcase record);

    List<TbBookcase> selectByExample(TbBookcaseExample example);

    TbBookcase selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbBookcase record, @Param("example") TbBookcaseExample example);

    int updateByExample(@Param("record") TbBookcase record, @Param("example") TbBookcaseExample example);

    int updateByPrimaryKeySelective(TbBookcase record);

    int updateByPrimaryKey(TbBookcase record);
}