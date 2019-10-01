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
@WebServlet("/Request_Test4")
public class Request_Test4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头数据：referer,告诉浏览器我从那里来，请求数据从哪里来
        String referer = request.getHeader("referer");
        System.out.println(referer);//http://localhost/day7/login.html

        //防盗链
        if (referer != null){
            if (referer.contains("/day7")){
                System.out.println("正常播放---------------");
            }else {
                //盗链
                System.out.println("看电影来腾讯视频！！");
            }
        }

    }
}
