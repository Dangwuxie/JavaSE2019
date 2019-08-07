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
@WebServlet("/Request_Test3")
public class Request_Test3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头数据：user-Agent
        String agent = request.getHeader("user-agent");
        //判断浏览器版本
        if (agent.contains("Chrome")){
            //谷歌
            System.out.println("谷歌浏览器");
        }else if (agent.contains("Firefox")){
            //火狐
            System.out.println("火狐浏览器");
        }
    }
}
