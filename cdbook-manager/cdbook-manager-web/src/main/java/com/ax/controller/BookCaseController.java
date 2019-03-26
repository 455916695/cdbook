package com.ax.controller;

import com.ax.entity.Result;
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

  @Autowired private BookCaseService bookCaseService;

  @RequestMapping("/addBookToCase")
  @ResponseBody
  public Result addBookToCase(String lid, TbBook book) {
    Result result = null;
    try {
      result = bookCaseService.addBookToCase(lid, book);
    } catch (Exception e) {
      result = new Result(false, e.getMessage());
    }
    return result;
  }

  @RequestMapping("/findCaseBook")
  @ResponseBody
  public List<TbBook> findCaseBook(String lid) {
    List<TbBook> caseBook = null;
    try {
      caseBook = bookCaseService.findCaseBook(lid);
    } catch (Exception e) {
      e.getMessage();
    }
    return caseBook;
  }

  @RequestMapping("/findLendingBook")
  @ResponseBody
  public List<TbBook> findLendingBook(String lid) {
    List<TbBook> lendingBook = null;
    try {
      lendingBook = bookCaseService.findLendingBook(lid);
    } catch (Exception e) {
      e.getMessage();
    }
    return lendingBook;
  }

  @RequestMapping("/findLendBook")
  @ResponseBody
  public List<TbBook> findLendBook(String lid) {
    List<TbBook> lendBook = null;
    try {
      lendBook = bookCaseService.findLendBook(lid);
    } catch (Exception e) {
      e.getMessage();
    }
    return lendBook;
  }

  @RequestMapping("/findReturnBook")
  @ResponseBody
  public List<TbBook> findReturnBook(String lid) {
    List<TbBook> returnBook = null;
    try {
      returnBook = bookCaseService.findReturnBook(lid);
    } catch (Exception e) {
      e.getMessage();
    }
    return returnBook;
  }

  @RequestMapping("/deleteBookToCase")
  @ResponseBody
  public Result deleteBookToCase(String bookId) {
    Result result = null;
    try {
      bookCaseService.deleteBookToCase(bookId);
      result = new Result(true, "删除成功");
    } catch (Exception e) {
      e.getMessage();
      result = new Result(false, e.getMessage());
    }
    return result;
  }
}
