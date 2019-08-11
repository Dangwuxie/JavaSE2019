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
@WebServlet("/ServletContext_Test3")
public class ServletContext_Test3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示ServletContext对象的功能
        //首先获取Context对象
        ServletContext context = this.getServletContext();
        //设置数据
        context.setAttribute("msg","hehe");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
