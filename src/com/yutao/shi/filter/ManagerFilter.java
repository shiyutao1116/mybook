package com.yutao.shi.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author shiyutao
 * @create 2021-10-29 20:01
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        Object user = request.getSession().getAttribute("user");
        if(user==null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
            return;
        }
        else {
            filterChain.doFilter(servletRequest,servletResponse);


        }

    }

    @Override
    public void destroy() {

    }
}
