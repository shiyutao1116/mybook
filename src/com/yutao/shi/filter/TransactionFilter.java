package com.yutao.shi.filter;

import com.yutao.shi.utils.JdbcU;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author shiyutao
 * @create 2021-10-29 21:49
 */
public class TransactionFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcU.commitandclose();
        }catch (Exception e){
            JdbcU.rollbackadnclose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
