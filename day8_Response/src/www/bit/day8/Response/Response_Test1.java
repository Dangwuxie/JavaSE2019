package www.bit.day8.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day8_Response
 * @Description:  完成重定向，
 * @date 2019/8/9 12:07
 */
@WebServlet("/Response_Test1")
public class Response_Test1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test1被访问了");

        //访问test1会自动跳转到test2这资源
        //设置状态码
       /* response.setStatus(302);
        //设置响应头
        response.setHeader("location","/day8/Response_Test2");*/
        //简单的重定向方法
        //response.sendRedirect("https://www.jd.com/");

        //获取动态虚拟目录：
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        //简单的重定向方法
        response.sendRedirect(contextPath+"/Response_Test3");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
