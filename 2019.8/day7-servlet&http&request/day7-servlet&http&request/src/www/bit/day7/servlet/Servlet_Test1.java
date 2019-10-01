package www.bit.day7.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Servlet_Test1
 * @ProjectName day7-servlet&http&request
 * @Description: TODO
 * @date 2019/8/7 12:09
 */
@WebServlet("/dome1")
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
        System.out.println("今天星期三");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
