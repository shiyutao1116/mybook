package com.yutao.shi.test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yutao.shi.dao.BookDAO;
import com.yutao.shi.dao.impl.BookDAOimpl;
import com.yutao.shi.pojo.Book;
import com.yutao.shi.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shiyutao
 * @create 2021-10-21 17:15
 */
public class BookDAOTest {

    private BookDAO bookDAO= new BookDAOimpl();
    @Test
    public void addbook() {
        bookDAO.addbook(new Book(null,"2",new BigDecimal(122),"2",2,2,null));
    }

    @Test
    public void deletebookbyid() {
        bookDAO.deletebookbyid(21);
    }

    @Test
    public void updatebook() {
        bookDAO.updatebook(new Book(21,"22",new BigDecimal(111),"2",66,2,null));
    }

    @Test
    public void querybookbyid() {
        System.out.println(bookDAO.querybookbyid(21));
    }

    @Test
    public void querybooks() {
        System.out.println(bookDAO.querybooks());
    }
    @Test
    public void quertforpagetatolcount() {
        System.out.println(bookDAO.queryforpagetatolcount());

    }
    @Test
    public void queryforitems() {
        for (Book book : bookDAO.queryforitems(8, Page.PAGE_SIZE)){
            System.out.println(book);
        }
    }
    @Test
    public void quertforpagetatolcountbyprice() {
        System.out.println(bookDAO.queryforpagetatolcountbyprice(10,50));

    }
    @Test
    public void queryforitemsbyprice() {
        for (Book book : bookDAO.queryforitemsbyprice(0, Page.PAGE_SIZE,10,50)){
            System.out.println(book);
        }
    }
}