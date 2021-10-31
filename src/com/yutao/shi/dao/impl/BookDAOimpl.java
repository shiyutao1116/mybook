package com.yutao.shi.dao.impl;

import com.yutao.shi.dao.BookDAO;
import com.yutao.shi.pojo.Book;
import com.yutao.shi.pojo.User;

import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-21 16:42
 */
public class BookDAOimpl extends BaseDAO implements BookDAO{


    @Override
    public int addbook(Book book) {
        String sql="insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`)values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgpath());

    }

    @Override
    public int deletebookbyid(Integer id) {
        String sql="delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updatebook(Book book) {
        String sql="update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where `id`=?";
        return update(sql,book.getName(),book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgpath(),book.getId());

    }

    @Override
    public Book querybookbyid(Integer id) {
        String sql="select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgpath from t_book where id=?";
        return searchone(Book.class,sql,id);
    }

    @Override
    public List<Book> querybooks() {
        String sql="select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgpath from t_book";
        return searchmany(Book.class,sql);
    }

    @Override
    public Integer queryforpagetatolcount() {
        String sql="select count(*) from t_book";
        Number value = (Number) searchforsinglevalue(sql);
        return value.intValue();
    }

    @Override
    public List<Book> queryforitems(int begin, int pagesize) {
        String sql="select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgpath from t_book limit ?,?";
        return searchmany(Book.class,sql,begin,pagesize);
    }

    @Override
    public Integer queryforpagetatolcountbyprice(int min, int max) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number value = (Number) searchforsinglevalue(sql,min,max);
        return value.intValue();
    }

    @Override
    public List<Book> queryforitemsbyprice(int begin, int pagesize, int min, int max) {
        String sql="select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgpath from t_book" +
                " where price between ? and ? order by price limit ?,?";
        return searchmany(Book.class,sql,min,max,begin,pagesize);
    }
}
