package com.ax.service.impl;

import com.ax.mapper.TbTypeMapper;
import com.ax.pojo.TbBookExample;
import com.ax.pojo.TbType;
import com.ax.pojo.TbTypeExample;
import com.ax.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TbTypeMapper typeMapper;
    @Override
    public List<TbType> findAll() {

        TbTypeExample typeExample = new TbTypeExample();
        typeExample.createCriteria().andIdIsNotNull();
        List<TbType> tbTypes = typeMapper.selectByExample(typeExample);
        return tbTypes;
    }
}
