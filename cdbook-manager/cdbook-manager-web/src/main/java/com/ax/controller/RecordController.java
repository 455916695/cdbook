package com.ax.controller;

import com.ax.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;

    @RequestMapping("/addLoanOut")
    @ResponseBody
    public void addLoanOut(String lid, String bookname, String bookId) {

    }

    @RequestMapping("/addLoanIn")
    @ResponseBody
    public void addLoanIn(String bid, String bookname, String bookId) {

    }

    @RequestMapping("/addReturn")
    @ResponseBody
    public void addReturn(String bid, String bookname, String bookId) {

    }
}
