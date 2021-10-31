package com.yutao.shi.test;

import com.yutao.shi.pojo.Book;
import com.yutao.shi.service.Bookservice;
import com.yutao.shi.service.impl.BookserviceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author shiyutao
 * @create 2021-10-21 21:04
 */
public class BookserviceTest {
private Bookservice bookservice=new BookserviceImpl();
    @Test
    public void addbook() {
        bookservice.addbook(new Book(null,"1",new BigDecimal(111),"1",1,1,null));
    }

    @Test
    public void deletebook() {
        bookservice.deletebook(22);
    }

    @Test
    public void updatebook() {
        bookservice.updatebook(new Book(22,"1",new BigDecimal(222),"2",2,2,null));
    }

    @Test
    public void querybook() {
        System.out.println(bookservice.querybook(22));
    }

    @Test
    public void querybooks() {
        System.out.println(bookservice.querybooks());
    }
    @Test
    public void page() {
        System.out.println(bookservice.page(2,4));
    }
}