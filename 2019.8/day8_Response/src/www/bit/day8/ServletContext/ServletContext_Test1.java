package www.bit.day8.ServletContext;

import javax.servlet.ServletContext;
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
 * @Description: TODO
 * @date 2019/8/10 0:09
 */
@WebServlet("/ServletContext_Test1")
public class ServletContext_Test1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示ServletContext对象的获取方式
        /*1、通过requsest对象来获取；
                request.getServletContext();
        2、通过httpServlet来获取
                httpServlet.getServletContext();
        */
        ServletContext context1 = request.getServletContext();
        ServletContext context2 = this.getServletContext();
        System.out.println(context1 == context2);//true
        System.out.println(context1);
        System.out.println(context2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
