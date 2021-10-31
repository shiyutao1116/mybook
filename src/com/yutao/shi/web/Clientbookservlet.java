package com.yutao.shi.web;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yutao.shi.pojo.Book;
import com.yutao.shi.pojo.Page;
import com.yutao.shi.service.Bookservice;
import com.yutao.shi.service.impl.BookserviceImpl;
import com.yutao.shi.utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shiyutao
 * @create 2021-10-24 16:41
 */
public class Clientbookservlet extends Baseservlet {
        private Bookservice bookservice=new BookserviceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageno = Webutils.parseint(req.getParameter("pageno"),1);
        int pagesize = Webutils.parseint(getInitParameter("pagesize"), Page.PAGE_SIZE);
        Page<Book> page= bookservice.page(pageno,pagesize);
        page.setUrl("client/bookservlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
    protected void pagebyprice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageno = Webutils.parseint(req.getParameter("pageno"),1);
        int pagesize = Webutils.parseint(getInitParameter("pagesize"), Page.PAGE_SIZE);
        int min=Webutils.parseint(req.getParameter("min"),0);
        int max=Webutils.parseint(req.getParameter("max"),Integer.MAX_VALUE);
        Page<Book> page= bookservice.pagebyprice(pageno,pagesize,min,max);
        StringBuilder stringBuilder=new StringBuilder("client/bookservlet?action=pagebyprice");
        if(req.getParameter("min")!=null){
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(stringBuilder+"");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

}
