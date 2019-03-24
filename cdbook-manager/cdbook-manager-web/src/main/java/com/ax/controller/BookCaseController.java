package com.ax.controller;

import com.ax.pojo.TbBook;
import com.ax.service.BookCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/case")
public class BookCaseController {

    @Autowired
    private BookCaseService bookCaseService;

    @RequestMapping("/addBookToCase")
    @ResponseBody
    public void addBookToCase(String lid, TbBook book) {
        try {
            bookCaseService.addBookToCase(lid,book);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @RequestMapping("/findCaseBook")
    @ResponseBody
    public List<TbBook> findCaseBook(String lid) {
        try {
            List<TbBook> caseBook = bookCaseService.findCaseBook(lid);
            return caseBook;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
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
