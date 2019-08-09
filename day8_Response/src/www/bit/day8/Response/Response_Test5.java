package www.bit.day8.Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
 * @date 2019/8/9 12:07
 */
@WebServlet("/Response_Test5")
public class Response_Test5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取字节输出流
        ServletOutputStream sos = response.getOutputStream();

        //获取输出数据
        sos.write("hello".getBytes());
        sos.write("你好".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
