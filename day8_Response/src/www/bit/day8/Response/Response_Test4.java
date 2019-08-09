package www.bit.day8.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day8_Response
 * @Description: TODO
 * @date 2019/8/9 12:07
 */
@WebServlet("/Response_Test4")
public class Response_Test4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GBK");
        response.setHeader("Content-Type","text/html; charset=utf-8");
        //1、获取字符输出流
        PrintWriter pw = response.getWriter();
        //2、输出数据
        /*pw.write("<h1>Test44444444444444</h1>");*/

        pw.write("<h1>你好</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
