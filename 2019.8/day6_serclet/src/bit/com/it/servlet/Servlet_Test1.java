package bit.com.it.servlet;

import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Servlet_Test1
 * @ProjectName Tomcat
 * @Description: TODO
 * @date 2019/8/6 17:36
 */
//@WebServlet(urlPatterns = "/demo")
@WebServlet("/demo2")
public class Servlet_Test1 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet3.0来了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
