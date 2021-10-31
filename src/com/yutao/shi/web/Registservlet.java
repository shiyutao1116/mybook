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
 * @create 2021-10-15 16:18
 */
public class Registservlet extends HttpServlet{
    private UserService userservice=new UserserviceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if("abcde".equalsIgnoreCase(code)){
            if (userservice.exitsUsername(username)){
                System.out.println("用户名已存在");
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else  {
                userservice.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }
        else{
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);


        }


    }
}
