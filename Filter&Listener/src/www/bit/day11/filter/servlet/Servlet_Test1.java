package www.bit.day11.filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName Filter&Listener
 * @Description: TODO
 * @date 2019/8/13 15:24
 */
@WebServlet("/user/Servlet_Test1")
public class Servlet_Test1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
