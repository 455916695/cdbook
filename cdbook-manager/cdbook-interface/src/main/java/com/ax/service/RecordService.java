package com.ax.service;

//记录项中，存在  借出，借入，归还)
public interface RecordService {

    /**
     * (
     * 1.添加借出记录
     */
    void addLoanOut(String lid, String bookname, String bookId);


    /**
     * 2.添加借入记录
     */
    void addLoanIn(String bid, String bookname, String bookId);

    /**
     * 3.添加归还记录
     */
    void addReturn(String bid, String bookname, String bookId);

}
