package com.yutao.shi.web;


import com.sun.javaws.progress.PreloaderDelegate;
import com.yutao.shi.pojo.Book;
import com.yutao.shi.pojo.Page;
import com.yutao.shi.service.Bookservice;
import com.yutao.shi.service.impl.BookserviceImpl;
import com.yutao.shi.utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shiyutao
 * @create 2021-10-21 21:10
 */
public class Bookservlet extends Baseservlet {
    private Bookservice bookservice=new BookserviceImpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageno=Webutils.parseint(req.getParameter("pageno"),0);
        pageno+=1;
        Book book= Webutils.copyparmtobean(req.getParameterMap(),new Book());
        bookservice.addbook(book);
        resp.sendRedirect( req.getContextPath()+"/manager/bookservlet?action=page&pageno="+pageno);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int parseint = Webutils.parseint(id, 0);
        bookservice.deletebook(parseint);
        resp.sendRedirect(req.getContextPath()+"/manager/bookservlet?action=page&pageno="+req.getParameter("pageno"));
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=Webutils.copyparmtobean(req.getParameterMap(),new Book());
        bookservice.updatebook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookservlet?action=page&pageno="+req.getParameter("pageno"));

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> querybooks = bookservice.querybooks();
        req.setAttribute("books",querybooks);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    protected void getbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int parseint = Webutils.parseint(id, 0);
        Book querybook = bookservice.querybook(parseint);
        req.setAttribute("book",querybook);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageno = Webutils.parseint(req.getParameter("pageno"),1);
        int pagesize = Webutils.parseint(getInitParameter("pagesize"), Page.PAGE_SIZE);
        Page<Book> page= bookservice.page(pageno,pagesize);
        page.setUrl("manager/bookservlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
