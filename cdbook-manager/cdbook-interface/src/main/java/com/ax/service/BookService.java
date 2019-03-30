package com.ax.service;

import com.ax.entity.PageResult;
import com.ax.entity.Result;
import com.ax.pojo.TbBook;

import java.util.List;

public interface BookService {

    /** 1.查询热门书籍 （首页） */
    List<TbBook> findHotBook();

    /** 2.最新发布书籍 （首页） */
    Result addBook(TbBook book);

    /** 3.根据分类查询书籍 （首页中） */
    List<TbBook> findBookByType(String cid); // cid  是 分类id

    /** * 4.查询指定书本详情 （根据书的id） */
    TbBook findBookById(String id);

    /** 查询最新书籍 */
    public List<TbBook> findLatestBooks();

    /** 查询分页书籍 */
    PageResult findBookPage(TbBook book, int pageNum, int pageSize);
}
