package com.ax.controller;

import com.ax.pojo.TbBook;
import com.ax.service.BookCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookCaseController {

    @Autowired
    private BookCaseService bookCaseService;

    @RequestMapping("/addBookToCase")
    @ResponseBody
    public void addBookToCase(String lid, TbBook book) {

    }

    @RequestMapping("/findCaseBook")
    @ResponseBody
    public List<TbBook> findCaseBook(String lid) {
        return null;
    }

    @RequestMapping("/findLendingBook")
    @ResponseBody
    public List<TbBook> findLendingBook(String lid) {
        return null;
    }

    @RequestMapping("/findLendBook")
    @ResponseBody
    public List<TbBook> findLendBook(String lid) {
        return null;
    }

    @RequestMapping("/findReturnBook")
    @ResponseBody
    public List<TbBook> findReturnBook(String lid) {
        return null;
    }

    @RequestMapping("/deleteBookToCase")
    @ResponseBody
    public void deleteBookToCase(String bookId) {

    }
}
