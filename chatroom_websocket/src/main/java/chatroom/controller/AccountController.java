package chatroom.controller;

import chatroom.service.AccountService;

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
 * @ProjectName chatroom_websocket
 * @Description: TODO
 * @date 2019/8/18 23:18
 */
@WebServlet("/doRegister")
public class AccountController extends HttpServlet {
    private AccountService accountService = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=utf8");
        PrintWriter writer = response.getWriter();
        if (accountService.userRegister(username,password)){
            //此时代表用户注册成功，那么弹出提示框注册成功，点击确定后返回登陆页面
            writer.println("<script>\n" +
                    "    alert(\"注册成功！\");\n" +
                    "    window.location.href = \"/index.html\";\n" +
                    "</script>");
        }else {
            //注册失败，用户名可能存在
            writer.println("<script>\n" +
                    "    alert(\"注册失败，用户名已存在！\");\n" +
                    "    window.location.href = \"/registration.html\";\n" +
                    "</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
