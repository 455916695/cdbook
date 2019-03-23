package com.ax.controller;

import com.ax.pojo.TbBook;
import com.ax.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/findHotBook")
    @ResponseBody
    public List<TbBook> findHotBook() {
        return null;
    }

    @RequestMapping("/addBook")
    @ResponseBody
    public void addBook(TbBook book) {

    }

    @RequestMapping("/findBookByType")
    @ResponseBody
    public List<TbBook> findBookByType(String cid) {
        return null;
    }

    @RequestMapping("/findBookById")
    @ResponseBody
    public TbBook findBookById(String id) {
        return null;
    }
}
