package com.ax.mapper;

import com.alibaba.druid.util.StringUtils;
import com.ax.pojo.TbBook;
import com.ax.pojo.TbBookbag;
import com.ax.pojo.TbBookbagExample;
import com.ax.pojo.TbBookcaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBookbagMapper {

    int countByExample(TbBookbagExample example);

    int deleteByExamples(TbBookbagExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbBookbag record);

    int insertSelective(TbBookbag record);

    List<TbBookbag> selectByExample(TbBookbagExample example);

    TbBookbag selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbBookbag record, @Param("example") TbBookbagExample example);

    int updateByExample(@Param("record") TbBookbag record, @Param("example") TbBookbagExample example);

    int updateByPrimaryKeySelective(TbBookbag record);

    int updateByPrimaryKey(TbBookbag record);

    TbBook selectBooKById(String bookId);

    int updateBook(TbBook tbBook);

    int deleteBook(String bookId);
}