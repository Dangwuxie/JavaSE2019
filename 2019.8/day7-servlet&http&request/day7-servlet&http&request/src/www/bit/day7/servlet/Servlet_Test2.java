package www.bit.day7.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Servlet_Test2
 * @ProjectName day7-servlet&http&request
 * @Description: TODO
 * @date 2019/8/7 12:32
 */
@WebServlet("/demo2")
public class Servlet_Test2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo2------------------");
    }
}
