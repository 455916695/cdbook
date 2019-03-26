package com.ax.service;

import com.ax.pojo.TbBook;

import java.util.List;

public interface BookBagService {

  /** 1.请求借入书籍 （在书本详情页面中 ） //向 BookBag 中添加记录，并修改 book的状态请求借入中 */
  void addBookToBag(String bid, String bookId);

  /** 2.确认已借入 （借书人的动作） //修改书的状态为确定借入 */
  void addNotarize(String bookId);

  /** 3.查询借入中的书籍 （在书包页面中） (//通过自己的id) */
  List<TbBook> findLendingBook(String bid);

  /** 4. 查询借入 的书籍 （在书包页面中） (//通过自己的id) */
  List<TbBook> findLendBook(String bid);

  /** 5.查询还出的书籍 （在书包页面中） (//通过自己的id) */
  List<TbBook> findReturnBook(String bid);

  /** 6.决定还书 （在书包页面调用） */
  void addReturnBook(String bid, String bookId);

  /** 7.确定收回书籍 （借出人的动作） （在书架页面调用，） （//删除书包中的数据，同时删除书架中的数据） */
  void delete(String bid, String bookId);
}
