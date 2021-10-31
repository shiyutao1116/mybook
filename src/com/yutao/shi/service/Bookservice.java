package com.yutao.shi.service;

import com.yutao.shi.pojo.Book;
import com.yutao.shi.pojo.Page;

import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-21 20:56
 */
public interface Bookservice {
    public void addbook(Book book);
    public void deletebook(Integer id);
    public void updatebook(Book book);
    public Book querybook(Integer id);
    public List<Book> querybooks();
    public Page<Book> page(int pageno, int pagesize);
    Page<Book> pagebyprice(int pageno, int pagesize, int min, int max);
}
