package com.ax.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ax.mapper.TbBookcaseMapper;
import com.ax.pojo.*;
import com.ax.service.BookCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BookCaseServiceImpl implements BookCaseService {


    @Autowired
    private TbBookcaseMapper bookcaseMapper;

    @Override
    public void addBookToCase(String lid, TbBook book) {

        //判断书籍的接收完整性
        if(book == null || StringUtils.isEmpty(book.getName()) || StringUtils.isEmpty(book.getImage()) ||
                StringUtils.isEmpty(book.getCid())){
            return;
        }
        book.setId(UUID.randomUUID().toString());
        book.setStatus(1);
        book.setBid(lid);
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
    }

    @Override
    public List<TbBook> findCaseBook(String lid) {

        return this.stateOfBooks(lid,1);
    }

    @Override
    public List<TbBook> findLendingBook(String lid) {

        return this.stateOfBooks(lid,2);
    }

    @Override
    public List<TbBook> findLendBook(String lid) {

        return this.stateOfBooks(lid,3);
    }

    @Override
    public List<TbBook> findReturnBook(String lid) {

        return this.stateOfBooks(lid,4);
    }

    @Override
    public void deleteBookToCase(String bookId) {

        //删除书
        bookcaseMapper.deleteBook(bookId);
        //删除书架中的书
        TbBookcaseExample bookcaseExample = new TbBookcaseExample();
        bookcaseExample.createCriteria().andBookIdEqualTo(bookId);
        bookcaseMapper.deleteByExample(bookcaseExample);
    }


    public List<TbBook> stateOfBooks(String bid,Integer state){
        //查询属于bid的书包
        TbBookcaseExample bookcaseExample = new TbBookcaseExample();
        bookcaseExample.createCriteria().andBidEqualTo(bid);
        List<TbBookcase> tbBookcases = bookcaseMapper.selectByExample(bookcaseExample);
        List<TbBook> books = new ArrayList<TbBook>();
        for (TbBookcase bookcase:tbBookcases) {
            TbBook tbBook = bookcaseMapper.selectBooKById(bookcase.getBookId());
            if(tbBook.getStatus()==state){
                books.add(tbBook);
            }
        }
        return books;
    }
}
