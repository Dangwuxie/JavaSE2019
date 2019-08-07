package www.bit.day7.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day7-servlet&http&request
 * @Description: 演示request对象来获取请求行数据
 * @date 2019/8/7 23:24
 */
@WebServlet("/Request_Test1")
public class Request_Test1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1、获取请求方式：GET，方法：String getMethod()
         * 2、获取虚拟目录：/day7，方法String getContextPath()
         * 3、获取Servlet的路径：/demo1，方法，String getServletPath()
         * 4、获取get方式的请求参数：name=zhangsan，
         *         String getQueryString()
         * 5、获取请求的URI：
         *         String getRequestURI(): /day7/demo1
         *         StringBuffer getRequestURL:http://localhost/day7/demo1
         * 6、获取协议及版本：HTTP/1.1
         *         String getProtocol()
         * 7、获取客户机IP地址
         *         String getRemoteAddr()
         */

        //1、获取请求方式：GET，方法：String getMethod()
        String method = request.getMethod();
        System.out.println(method);
        //2、获取虚拟目录：/day7，方法String getContextPath()
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //3、获取Servlet的路径：/demo1，方法，String getServletPath()
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        //4、获取get方式的请求参数：name=zhangsan，String getQueryString()
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //5、获取请求的URI：
        //String getRequestURI(): /day7/demo1
        //StringBuffer getRequestURL:http://localhost/day7/demo1
        String URIString = request.getRequestURI();
        StringBuffer URLString = request.getRequestURL();
        System.out.println(URIString);
        System.out.println(URLString);
        //6、获取协议及版本：HTTP/1.1
        // String getProtocol()
        String protocol = request.getProtocol();
        System.out.println(protocol);
        //7、获取客户机IP地址
        // String getRemoteAddr()
        String ADDString = request.getRemoteAddr();
        System.out.println(ADDString);

    }
}
