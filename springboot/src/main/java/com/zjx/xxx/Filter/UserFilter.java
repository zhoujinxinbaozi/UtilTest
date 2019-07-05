package com.zjx.xxx.Filter;

import org.apache.tomcat.util.descriptor.InputSourceUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "userFilter", urlPatterns = "/springboot/getUserByGet/*")
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("Filter doFilter");
        String userName = servletRequest.getParameter("userName");
        String userAge = servletRequest.getParameter("userAge");
        System.out.println("name = " + userName + "\tage = " + userAge);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy");
    }
}
