package com.ax.service;

import com.ax.entity.Result;

// 记录项中，存在  借出，借入，归还)
public interface RecordService {

  /** ( 1.添加借出记录 */
  Result addLoanOut(String lid, String bookname, String bookId);

  /** 2.添加借入记录 */
  Result addLoanIn(String bid, String bookname, String bookId);

  /** 3.添加归还记录 */
  Result addReturn(String bid, String bookname, String bookId);
}
