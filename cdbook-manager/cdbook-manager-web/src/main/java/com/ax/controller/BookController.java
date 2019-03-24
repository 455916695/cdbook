package com.ax.controller;

import com.ax.entity.Result;
import com.ax.pojo.TbBook;
import com.ax.pojo.TbUser;
import com.ax.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/findHotBook")
    @ResponseBody
    public List<TbBook> findHotBook() {
        try {
            List<TbBook> hotBooks = bookService.findHotBook();
            return hotBooks;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/addBook")
    @ResponseBody
    public void addBook(TbBook book, HttpServletRequest request) {
        try {
            //获得上传书籍的用户id
            book.setBid(((TbUser) request.getSession().getAttribute("user")).getId());
            bookService.addBook(book);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/findBookByType")
    @ResponseBody
    public List<TbBook> findBookByType(String cid) {
        try {
            List<TbBook> booksByType = bookService.findBookByType(cid);
            return booksByType;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/findBookById")
    @ResponseBody
    public TbBook findBookById(String id) {
        try {
            TbBook book = bookService.findBookById(id);
            return book;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
