package com.yutao.shi.web;

import com.yutao.shi.pojo.User;
import com.yutao.shi.service.UserService;
import com.yutao.shi.service.impl.UserserviceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shiyutao
 * @create 2021-10-15 21:04
 */
public class Loginservlet extends HttpServlet {
    private UserService userservice = new UserserviceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(userservice.login(new User(null,username,password,null))!=null){
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);


        }
        else {

            req.setAttribute("msg","用户或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }

    }
}