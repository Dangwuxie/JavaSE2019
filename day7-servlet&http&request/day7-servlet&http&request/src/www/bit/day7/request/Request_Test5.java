package www.bit.day7.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day7-servlet&http&request
 * @Description: TODO
 * @date 2019/8/8 0:12
 */
@WebServlet("/Request_Test5")
public class Request_Test5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息体
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine())!=null){
            System.out.println(str);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
