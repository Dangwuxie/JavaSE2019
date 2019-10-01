package www.bit.day8.loginServlet;

import www.bit.day8.registTest.User;

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
 * @date 2019/8/8 18:55
 */
@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先获取request域中共享的user对象
        User user = (User) request.getAttribute("user");
        User loginuser = (User) request.getAttribute("loginuser");
        //给页面写一句话
        //设置编码，response
        response.setContentType("text/html;charset=utf-8");
        //输出
        response.getWriter().write("登录成功！"+loginuser.getUsername()+"   "+user.getUsername()+",欢迎您");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
