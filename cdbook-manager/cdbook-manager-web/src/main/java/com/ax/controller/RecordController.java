package com.ax.controller;

import com.ax.entity.Result;
import com.ax.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/record")
public class RecordController {

  @Autowired private RecordService recordService;

  @RequestMapping("/addLoanOut")
  @ResponseBody
  public Result addLoanOut(String lid, String bookname, String bookId) {
    Result result = null;
    try {
      result = recordService.addLoanOut(lid, bookname, bookId);
    } catch (Exception e) {
      result = new Result(false, e.getMessage());
    }
    return result;
  }

  @RequestMapping("/addLoanIn")
  @ResponseBody
  public Result addLoanIn(String bid, String bookname, String bookId) {
    Result result = null;
    try {
      result = recordService.addLoanIn(bid, bookname, bookId);
    } catch (Exception e) {
      result = new Result(false, e.getMessage());
    }
    return result;
  }

  @RequestMapping("/addReturn")
  @ResponseBody
  public Result addReturn(String bid, String bookname, String bookId) {
    Result result = null;
    try {
      result = recordService.addReturn(bid, bookname, bookId);
    } catch (Exception e) {
      result = new Result(false, e.getMessage());
    }
    return result;
  }
}
