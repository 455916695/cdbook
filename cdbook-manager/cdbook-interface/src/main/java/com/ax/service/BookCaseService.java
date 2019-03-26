package com.ax.service;

import com.ax.entity.Result;
import com.ax.pojo.TbBook;

import java.util.List;

public interface BookCaseService {

  /** 1.发布书籍 （已发布未借出） */
  Result addBookToCase(String lid, TbBook book);

  /** 2.显示发布的书籍 */
  List<TbBook> findCaseBook(String lid);

  /** 3.显示借出中的书籍 */
  List<TbBook> findLendingBook(String lid);

  /** 4.显示借出的书籍 */
  List<TbBook> findLendBook(String lid);

  /** 5.显示归还中的书籍 */
  List<TbBook> findReturnBook(String lid);

  /** 6.删除借书 （已发布未借出，归还后） 删除两次，一次删除book中的数据，一次删除书架中的数据 */
  void deleteBookToCase(String bookId);
}
