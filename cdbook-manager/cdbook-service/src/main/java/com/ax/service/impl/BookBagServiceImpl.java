package com.ax.service.impl;

import com.ax.mapper.TbBookbagMapper;
import com.ax.mapper.TbBookcaseMapper;
import com.ax.pojo.*;
import com.ax.service.BookBagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BookBagServiceImpl implements BookBagService {


    @Autowired
    private TbBookbagMapper bookbagMapper;
    @Autowired
    private TbBookcaseMapper bookcaseMapper;


    @Override
    public void addBookToBag(String bid, String bookId) {
        //获得加入的书籍，修改书籍的信息
        TbBook tbBook = bookbagMapper.selectBooKById(bookId);
        tbBook.setLid(bid);
        tbBook.setStatus(2);
        tbBook.setUpdateTime(new Date());
        //讲借的书加入书包
        TbBookbag tbBookbag = new TbBookbag();
        tbBookbag.setId(UUID.randomUUID().toString());
        tbBookbag.setLib(bid);
        tbBookbag.setBookId(bookId);
        tbBookbag.setCreateTime(new Date());
        tbBookbag.setUpdateTime(new Date());
        bookbagMapper.insert(tbBookbag);
    }

    @Override
    public void addNotarize(String bookId) {

        TbBook tbBook = bookbagMapper.selectBooKById(bookId);
        tbBook.setStatus(3);
        tbBook.setUpdateTime(new Date());
        bookbagMapper.updateBook(tbBook);
    }

    @Override
    public List<TbBook> findLendingBook(String bid) {
        return this.stateOfBook(bid,2);
    }

    @Override
    public List<TbBook> findLendBook(String bid) {
        return this.stateOfBook(bid,3);
    }

    @Override
    public List<TbBook> findReturnBook(String bid) {

        return this.stateOfBook(bid,4);
    }

    @Override
    public void addReturnBook(String bid, String bookId) {

        TbBook tbBook = bookbagMapper.selectBooKById(bookId);
        tbBook.setStatus(4);
        tbBook.setUpdateTime(new Date());
        bookbagMapper.updateBook(tbBook);
    }

    @Override
    public void delete(String bid, String bookId) {

        //删除书
        bookbagMapper.deleteBook(bookId);
        //删除书包中的数据
        TbBookbagExample bookbagExample = new TbBookbagExample();
        bookbagExample.createCriteria().andBookIdEqualTo(bookId);
        bookbagMapper.deleteByExamples(bookbagExample);
        //删除书架中的数据
        TbBookcaseExample bookcaseExample = new TbBookcaseExample();
        bookcaseExample.createCriteria().andBookIdEqualTo(bookId);
        bookcaseMapper.deleteByExample(bookcaseExample);
    }



    public List<TbBook> stateOfBook(String bid,Integer state){
        TbBookbagExample bookbagExample = new TbBookbagExample();
        bookbagExample.createCriteria().andLibEqualTo(bid);
        List<TbBookbag> tbBookbags = bookbagMapper.selectByExample(bookbagExample);
        List<TbBook> books = new ArrayList<TbBook>();
        for (TbBookbag bookbag:tbBookbags) {
            TbBook tbBook = bookbagMapper.selectBooKById(bookbag.getBookId());
            if(tbBook.getStatus()==state){
                books.add(tbBook);
            }
        }
        return books;
    }
}
