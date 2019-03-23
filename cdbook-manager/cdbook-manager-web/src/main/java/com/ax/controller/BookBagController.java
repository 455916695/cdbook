package com.ax.controller;

import com.ax.pojo.TbBook;
import com.ax.service.BookBagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookBagController {

    @Autowired
    private BookBagService bookBagService;


    @RequestMapping("/addBookToBag")
    @ResponseBody
    public void addBookToBag(String bid, String bookId) {

    }


    @RequestMapping("/addNotarize")
    @ResponseBody
    public void addNotarize(String bookId) {

    }


    @RequestMapping("/findLendingBook")
    @ResponseBody
    public List<TbBook> findLendingBook(String bid) {
        return null;
    }


    @RequestMapping("/findLendBook")
    @ResponseBody
    public List<TbBook> findLendBook(String bid) {
        return null;
    }


    @RequestMapping("/findReturnBook")
    @ResponseBody
    public List<TbBook> findReturnBook(String bid) {
        return null;
    }


    @RequestMapping("/addReturnBook")
    @ResponseBody
    public void addReturnBook(String bid, String bookId) {

    }


    @RequestMapping("/addBookToBag")
    @ResponseBody
    public void delete(String bid, String bookId) {

    }
}
