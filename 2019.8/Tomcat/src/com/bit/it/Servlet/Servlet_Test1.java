package com.bit.it.Servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Servlet_Test1
 * @ProjectName Tomcat
 * @Description: TODO
 * @date 2019/8/6 15:17
 */
public class Servlet_Test1 implements Servlet{


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("小苹果");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
