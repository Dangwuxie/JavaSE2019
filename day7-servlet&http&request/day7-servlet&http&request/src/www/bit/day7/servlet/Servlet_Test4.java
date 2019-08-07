package www.bit.day7.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Servlet_Test4
 * @ProjectName day7-servlet&http&request
 * @Description: TODO
 * @date 2019/8/7 14:08
 */

/**
 * Servlet路径配置
 */
//@WebServlet({"/d4","/dd4","/ddd4"})
//@WebServlet("/user/demo4")  //访问的时候这两层路径都要写上
//@WebServlet("/user/*")   //星号代表网页端访问什么都行
//@WebServlet("/*")  //代表什么样的资源都能访问到，优先级最低
@WebServlet("*.do") //不管写啥，加上任意名称.do，就是访问的这个类
public class Servlet_Test4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Test4-----------------");
        System.out.println(req);
    }
}
