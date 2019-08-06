package com.bit.it.Servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Servlet_Test2
 * @ProjectName Tomcat
 * @Description: Servlet方法解析
 * @date 2019/8/6 16:43
 */
/*
*           说一下着五个方法
*
* */
public class Servlet_Test2 implements Servlet {
    /**
     * 初始化方法，
     * 在Servlet被创建时执行，只会执行一次；
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化方法。。。。。。。。");
    }


    /**
     * 获取ServlectConfig对象
     * 这个对象其实就是Servlet的配置对象
     * 此方法需要我们自己去实现
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /**
     * 提供服务的方法，每一次Servlet被访问的时候都会被执行；
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("每一次都会被执行的方法service");
    }

    /**
     * 获取Servlet的一些信息
     * 版本、作者等等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }



    /**
     * 销毁方法，在Servlet被杀死的时候执行
     * 也就是说在服务器被关闭的时候执行
     */
    @Override
    public void destroy() {
        System.out.println("destory关闭方法。。。。。。。。。。。");
    }
}
