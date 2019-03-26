package com.ax.controller;

import com.ax.entity.Result;
import com.ax.pojo.TbBook;
import com.ax.service.BookBagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bag")
public class BookBagController {

  @Autowired private BookBagService bookBagService;

  @RequestMapping("/addBookToBags")
  @ResponseBody
  public Result addBookToBags(String bid, String bookId) {
    Result result = null;
    try {
      bookBagService.addBookToBag(bid, bookId);
      result = new Result(true, "添加成功");
    } catch (Exception e) {
      result = new Result(false, e.getMessage());
    }
    return result;
  }

  @RequestMapping("/addNotarize")
  @ResponseBody
  public Result addNotarize(String bookId) {
    Result result = null;
    try {
      bookBagService.addNotarize(bookId);
      result = new Result(true, "添加成功");
    } catch (Exception e) {
      result = new Result(false, e.getMessage());
    }
    return result;
  }

  @RequestMapping("/findLendingBooks")
  @ResponseBody
  public List<TbBook> findLendingBooks(String bid) {
    List<TbBook> lendingBooks = null;
    try {
      lendingBooks = bookBagService.findLendingBook(bid);
    } catch (Exception e) {
      e.getMessage();
    }
    return lendingBooks;
  }

  @RequestMapping("/findLendBooks")
  @ResponseBody
  public List<TbBook> findLendBooks(String bid) {
    List<TbBook> lendBooks = null;
    try {
      lendBooks = bookBagService.findLendBook(bid);
    } catch (Exception e) {
      e.getMessage();
    }
    return lendBooks;
  }

  @RequestMapping("/findReturnBooks")
  @ResponseBody
  public List<TbBook> findReturnBooks(String bid) {
    List<TbBook> returnBook = null;
    try {
      returnBook = bookBagService.findReturnBook(bid);
    } catch (Exception e) {
      e.getMessage();
    }
    return returnBook;
  }

  @RequestMapping("/addReturnBook")
  @ResponseBody
  public Result addReturnBook(String bid, String bookId) {
    Result result = null;
    try {
      bookBagService.addReturnBook(bid, bookId);
      result = new Result(true, "添加成功");
    } catch (Exception e) {
      result = new Result(false, e.getMessage());
    }
    return result;
  }

  @RequestMapping("/delete")
  @ResponseBody
  public Result delete(String bid, String bookId) {
    Result result = null;
    try {
      bookBagService.delete(bid, bookId);
      result = new Result(true, "删除成功");
    } catch (Exception e) {
      result = new Result(false, e.getMessage());
    }
    return result;
  }
}
