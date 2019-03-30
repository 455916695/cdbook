package com.ax.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.ax.entity.PageResult;
import com.ax.entity.Result;
import com.ax.mapper.TbBookMapper;
import com.ax.pojo.TbBook;
import com.ax.pojo.TbBookExample;
import com.ax.service.BookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
        //    TbBookExample tbBookExample = new TbBookExample();
        //    tbBookExample.createCriteria().andIsHotEqualTo(true);
        //    List<TbBook> tbBooks = bookMapper.selectByExample(tbBookExample);
        List<TbBook> tbBooks = bookMapper.selectHottestBooks();
        return tbBooks;
    }

    public List<TbBook> findLatestBooks() {
        //    TbBookExample tbBookExample = new TbBookExample();
        //    tbBookExample.createCriteria().andIsHotEqualTo(true);
        //    List<TbBook> tbBooks = bookMapper.selectByExample(tbBookExample);
        List<TbBook> tbBooks = bookMapper.selectLatestBooks();
        return tbBooks;
    }

    @Override
    public PageResult findBookPage(TbBook book, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbBookExample tbe = null;
        if (book != null) {
            tbe = new TbBookExample();
            TbBookExample.Criteria criteria = tbe.createCriteria();

            if (!StringUtils.isEmpty(book.getCid())) {
                criteria.andCidEqualTo(book.getCid());
            }
            // 此处可以扩展
        }

        Page<TbBook> page = (Page<TbBook>) bookMapper.selectByExample(tbe);

        return new PageResult(page.getTotal(), page.getResult());
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
