package com.yutao.shi.dao;

import com.yutao.shi.pojo.Book;

import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-21 16:42
 */
public interface BookDAO {
    public int addbook(Book book);
    public int deletebookbyid(Integer id);
    public int updatebook(Book book);
    public Book querybookbyid(Integer id);
    public List<Book> querybooks();
    public Integer queryforpagetatolcount();
    public List<Book> queryforitems(int begin,int pagesize);

    Integer queryforpagetatolcountbyprice(int min, int max);

    List<Book> queryforitemsbyprice(int begin, int pagesize,int min, int max);
}
