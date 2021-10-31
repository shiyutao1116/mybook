package com.yutao.shi.service.impl;

import com.yutao.shi.dao.BookDAO;
import com.yutao.shi.dao.impl.BookDAOimpl;
import com.yutao.shi.pojo.Book;
import com.yutao.shi.pojo.Page;
import com.yutao.shi.service.Bookservice;

import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-21 20:57
 */
public class BookserviceImpl implements Bookservice{
    private BookDAO bookdao=new BookDAOimpl();

    @Override
    public void addbook(Book book) {
    bookdao.addbook(book);
    }

    @Override
    public void deletebook(Integer id) {
    bookdao.deletebookbyid(id);
    }

    @Override
    public void updatebook(Book book) {
    bookdao.updatebook(book);
    }

    @Override
    public Book querybook(Integer id) {
        return bookdao.querybookbyid(id);
    }

    @Override
    public List<Book> querybooks() {
        return bookdao.querybooks();
    }

    @Override
    public Page<Book> page(int pageno, int pagesize) {
        Page<Book> page=new  Page<>();

        page.setPagesize(pagesize);
        Integer pagetotalcount=bookdao.queryforpagetatolcount();
        page.setPagetotalcount(pagetotalcount);
        Integer pagetotal;
        if (pagetotalcount%pagesize!=0){
             pagetotal=pagetotalcount/pagesize+1;
        }else {
            pagetotal=pagetotalcount/pagesize;
        }
        page.setPagetotal(pagetotal);

        page.setPageno(pageno);
        int begin=(page.getPageno()-1)*pagesize;
        List<Book> items=bookdao.queryforitems(begin,pagesize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pagebyprice(int pageno, int pagesize, int min, int max) {
        Page<Book> page=new  Page<>();

        page.setPagesize(pagesize);
        Integer pagetotalcount=bookdao.queryforpagetatolcountbyprice(min,max);
        page.setPagetotalcount(pagetotalcount);
        Integer pagetotal;
        if (pagetotalcount%pagesize!=0){
            pagetotal=pagetotalcount/pagesize+1;
        }else {
            pagetotal=pagetotalcount/pagesize;
        }
        page.setPagetotal(pagetotal);

        page.setPageno(pageno);
        int begin=(page.getPageno()-1)*pagesize;
        List<Book> items=bookdao.queryforitemsbyprice(begin,pagesize,min,max);
        page.setItems(items);
        return page;
    }




}
