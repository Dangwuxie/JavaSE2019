package www.bit.day9.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day9_cookie&session
 * @Description: TODO
 * @date 2019/8/11 9:35
 */
@WebServlet("/Session_Test3")
public class Session_Test3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用session共享数据

        //1、获取session
        HttpSession session = request.getSession();
        //期望客户端关闭后，session也能是同一个
        Cookie c = new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(60*60);
        response.addCookie(c);

        response.getWriter().write("999999999999999999999999999999");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
