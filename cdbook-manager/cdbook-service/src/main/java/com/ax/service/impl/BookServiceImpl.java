package com.ax.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ax.entity.Result;
import com.ax.mapper.TbBookMapper;
import com.ax.pojo.TbBook;
import com.ax.pojo.TbBookExample;
import com.ax.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

  @Autowired private TbBookMapper bookMapper;

  @Override
  public List<TbBook> findHotBook() {
    TbBookExample tbBookExample = new TbBookExample();
    tbBookExample.createCriteria().andIsHotEqualTo(true);
    List<TbBook> tbBooks = bookMapper.selectByExample(tbBookExample);
    return tbBooks;
  }

  @Override
  public Result addBook(TbBook book) {
    Result result = null;
    if (book == null
        || StringUtils.isEmpty(book.getName())
        || StringUtils.isEmpty(book.getImage())
        || StringUtils.isEmpty(book.getCid())
        || StringUtils.isEmpty(book.getBid())) {
      result = new Result(false, "请填写完整信息");
      return result;
    }
    book.setId(UUID.randomUUID().toString());
    book.setStatus(1);
    book.setCreateTime(new Date());

    book.setUpdateTime(new Date());
    bookMapper.insert(book);
    result = new Result(true, "上传成功", book);
    return result;
  }

  @Override
  public List<TbBook> findBookByType(String cid) {
    TbBookExample tbBookExample = new TbBookExample();
    tbBookExample.createCriteria().andCidEqualTo(cid);
    List<TbBook> tbBooks = bookMapper.selectByExample(tbBookExample);
    return tbBooks;
  }

  @Override
  public TbBook findBookById(String id) {
    TbBook tbBook = bookMapper.selectByPrimaryKey(id);
    return tbBook;
  }
}
