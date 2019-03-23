package com.ax.service.impl;

import com.ax.mapper.TbBookbagMapper;
import com.ax.pojo.TbBook;
import com.ax.service.BookBagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBagServiceImpl implements BookBagService {


    @Autowired
    private TbBookbagMapper bookbagMapper;

    @Override
    public void addBookToBag(String bid, String bookId) {
    }

    @Override
    public void addNotarize(String bookId) {

    }

    @Override
    public List<TbBook> findLendingBook(String bid) {
        return null;
    }

    @Override
    public List<TbBook> findLendBook(String bid) {
        return null;
    }

    @Override
    public List<TbBook> findReturnBook(String bid) {
        return null;
    }

    @Override
    public void addReturnBook(String bid, String bookId) {

    }

    @Override
    public void delete(String bid, String bookId) {

    }
}
