package com.ax.controller;

import com.alibaba.druid.util.StringUtils;
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

  @Autowired private BookService bookService;

  @RequestMapping("/findHotBook")
  @ResponseBody
  public List<TbBook> findHotBook() {
    List<TbBook> hotBooks = null;
    try {
      hotBooks = bookService.findHotBook();
    } catch (Exception e) {
      e.getMessage();
    }
    return hotBooks;
  }

  @RequestMapping("/findLatestBooks")
  @ResponseBody
  public List<TbBook> findLatestBooks() {
    List<TbBook> hotBooks = null;
    try {
      hotBooks = bookService.findLatestBooks();
    } catch (Exception e) {
      e.getMessage();
    }
    return hotBooks;
  }

  @RequestMapping("/addBook")
  @ResponseBody
  public Result addBook(TbBook book, HttpServletRequest request) {
    Result result = null;
    try {
      // 获得上传书籍的用户id
      TbUser user = (TbUser) request.getSession().getAttribute("user");
      if (user == null || StringUtils.isEmpty(user.getId())) {
        result = new Result(false, "请先登录");
        return result;
      }
      book.setBid(user.getId());
      result = bookService.addBook(book);
    } catch (Exception e) {
      result = new Result(false, e.getMessage());
    }
    return result;
  }

  @RequestMapping("/findBookByType")
  @ResponseBody
  public List<TbBook> findBookByType(String cid) {
    List<TbBook> booksByType = null;
    try {
      booksByType = bookService.findBookByType(cid);
    } catch (Exception e) {
      e.getMessage();
    }
    return booksByType;
  }

  @RequestMapping("/findBookById")
  @ResponseBody
  public TbBook findBookById(String id) {
    TbBook book = null;
    try {
      book = bookService.findBookById(id);
    } catch (Exception e) {
      e.getMessage();
    }
    return book;
  }
}
