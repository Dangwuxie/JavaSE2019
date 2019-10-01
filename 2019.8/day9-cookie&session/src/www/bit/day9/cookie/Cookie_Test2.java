package www.bit.day9.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day9_cookie&session
 * @Description: TODO
 * @date 2019/8/10 14:19
 */
@WebServlet("/Cookie_Test2")
public class Cookie_Test2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Cookie
        Cookie[] cookies = request.getCookies();

        if (cookies!=null){
            for (Cookie cs:cookies){
                String name = cs.getName();
                String value = cs.getValue();
                System.out.println(name+" "+value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
