package com.ax.service.impl;

import com.ax.pojo.TbBook;
import com.ax.service.BookCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCaseServiceImpl implements BookCaseService {
    @Override
    public void addBookToCase(String lid, TbBook book) {

    }

    @Override
    public List<TbBook> findCaseBook(String lid) {
        return null;
    }

    @Override
    public List<TbBook> findLendingBook(String lid) {
        return null;
    }

    @Override
    public List<TbBook> findLendBook(String lid) {
        return null;
    }

    @Override
    public List<TbBook> findReturnBook(String lid) {
        return null;
    }

    @Override
    public void deleteBookToCase(String bookId) {

    }
}
