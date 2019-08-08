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
 * @Description: TODO
 * @date 2019/8/8 0:12
 */
@WebServlet("/Request_Test8")
public class Request_Test8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("888888888888被访问了");

        //获取request域中的数据
        Object obj = request.getAttribute("msg");
        System.out.println(obj);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

