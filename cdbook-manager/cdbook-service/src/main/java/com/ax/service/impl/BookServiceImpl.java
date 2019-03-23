package com.ax.service.impl;

import com.ax.pojo.TbBook;
import com.ax.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService{
    @Override
    public List<TbBook> findHotBook() {
        return null;
    }

    @Override
    public void addBook(TbBook book) {

    }

    @Override
    public List<TbBook> findBookByType(String cid) {
        return null;
    }

    @Override
    public TbBook findBookById(String id) {
        return null;
    }
}
