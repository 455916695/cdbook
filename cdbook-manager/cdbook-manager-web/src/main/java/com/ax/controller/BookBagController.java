package com.ax.controller;

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

    @Autowired
    private BookBagService bookBagService;


    @RequestMapping("/addBookToBags")
    @ResponseBody
    public void addBookToBags(String bid, String bookId) {
        try{
            bookBagService.addBookToBag(bid,bookId);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    @RequestMapping("/addNotarize")
    @ResponseBody
    public void addNotarize(String bookId) {
        try{
            bookBagService.addNotarize(bookId);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }


    @RequestMapping("/findLendingBooks")
    @ResponseBody
    public List<TbBook> findLendingBooks(String bid) {
        try{
            List<TbBook> lendingBooks = bookBagService.findLendingBook(bid);
            return lendingBooks;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    @RequestMapping("/findLendBooks")
    @ResponseBody
    public List<TbBook> findLendBooks(String bid) {
        try{
            List<TbBook> lendBooks = bookBagService.findLendBook(bid);
            return lendBooks;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    @RequestMapping("/findReturnBooks")
    @ResponseBody
    public List<TbBook> findReturnBooks(String bid) {
        try{
            List<TbBook> returnBook = bookBagService.findReturnBook(bid);
            return returnBook;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    @RequestMapping("/addReturnBook")
    @ResponseBody
    public void addReturnBook(String bid, String bookId) {
        try{
            bookBagService.addReturnBook(bid,bookId);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String bid, String bookId) {

        try{
            bookBagService.delete(bid,bookId);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
