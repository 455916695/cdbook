package com.ax.mapper;

import com.ax.pojo.TbUser;
import com.ax.pojo.TbUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserMapper {
    int countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    /**
     * 根据用户名查询用户对象
     */
    TbUser selectUserByUsername(@Param("username") String username);
}