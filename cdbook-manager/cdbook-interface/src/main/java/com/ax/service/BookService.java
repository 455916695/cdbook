package com.ax.service;

import com.ax.pojo.TbBook;

import java.util.List;

public interface BookService {


    /**
     * 1.查询热门书籍 （首页）
     */
    List<TbBook> findHotBook();


    /**
     * 2.最新发布书籍 （首页）
     */
    void addBook(TbBook book);


    /**
     * 3.根据分类查询书籍 （首页中）
     */
    List<TbBook> findBookByType(String cid);  // cid  是 分类id


    /***
     *4.查询指定书本详情  （根据书的id）
     */
    TbBook findBookById(String id);

}
