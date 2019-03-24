package com.ax.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ax.mapper.TbRecordMapper;
import com.ax.pojo.TbBook;
import com.ax.pojo.TbRecord;
import com.ax.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class RecordServiceImpl implements RecordService {


    @Autowired
    private TbRecordMapper recordMapper;
    @Override
    public void addLoanOut(String lid, String bookname, String bookId) {

        if(StringUtils.isEmpty(lid) || StringUtils.isEmpty(bookname) || StringUtils.isEmpty(bookId)){
            return;
        }
        //查找书籍获得书籍的所有人id
        TbBook tbBook = recordMapper.selectBookByPrimaryKey(bookId);
        //创建记录对象并给属性赋值
        TbRecord record = this.createTbRecord(lid,bookname,tbBook.getBid(),1);
        recordMapper.insertSelective(record);
    }

    @Override
    public void addLoanIn(String bid, String bookname, String bookId) {

        if(StringUtils.isEmpty(bid) || StringUtils.isEmpty(bookname) || StringUtils.isEmpty(bookId)){
            return;
        }
        //查找书籍获得书籍的所有人id
        TbBook tbBook = recordMapper.selectBookByPrimaryKey(bookId);
        //创建记录对象并给属性赋值
        TbRecord record = this.createTbRecord(tbBook.getLid(),bookname,bid,2);
        recordMapper.insertSelective(record);
    }

    @Override
    public void addReturn(String bid, String bookname, String bookId) {

        if(StringUtils.isEmpty(bid) || StringUtils.isEmpty(bookname) || StringUtils.isEmpty(bookId)){
            return;
        }
        //查找书籍获得书籍的所有人id
        TbBook tbBook = recordMapper.selectBookByPrimaryKey(bookId);
        //创建记录对象并给属性赋值
        TbRecord record = this.createTbRecord(tbBook.getLid(),bookname,bid,3);
        recordMapper.insertSelective(record);
    }


    public TbRecord createTbRecord(String lid,String bookname,String bid,Integer state){
        TbRecord record = new TbRecord();
        record.setId(UUID.randomUUID().toString());
        record.setUserId(lid);
        record.setBookName(bookname);
        record.setBookId(bid);
        record.setStatus(state);
        record.setCreateTime(new Date());
        record.setUpdateTime(new Date());
        return record;

    }
}
