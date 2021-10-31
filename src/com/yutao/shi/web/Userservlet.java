package com.yutao.shi.web;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.google.gson.Gson;
import com.yutao.shi.pojo.User;
import com.yutao.shi.service.UserService;
import com.yutao.shi.service.impl.UserserviceImpl;
import com.yutao.shi.utils.Webutils;
import org.omg.CORBA.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author shiyutao
 * @create 2021-10-20 20:55
 */
public class Userservlet extends Baseservlet {
    private UserService userservice=new UserserviceImpl();
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath());



    }
    protected void ajaxexitusername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean exit = userservice.exitsUsername(username);
        Map<String,Object> map=new HashMap<>();
        map.put("exit",exit);
        Gson gson= new Gson();
        String s = gson.toJson(map);
        resp.getWriter().write(s);


    }






    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user =Webutils.copyparmtobean(req.getParameterMap(), new User());
        User loginuser= userservice.login(user);
        if(loginuser!=null){
            req.getSession().setAttribute("user",loginuser);

            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);


        }
        else {

            req.setAttribute("msg","用户或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }



    }




    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String attribute = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


        User user =Webutils.copyparmtobean(req.getParameterMap(), new User());
        if(attribute!=null&&attribute.equals(code)){
            if (userservice.exitsUsername(username)){
                System.out.println("用户名已存在");
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else  {
                userservice.registUser(user);
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





    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this, req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

