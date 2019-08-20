package chatroom.controller;

import chatroom.config.FreeMarkerListener;
import chatroom.service.AccountService;
import chatroom.utils.CommUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dangxuchao
 * @Title: LoginController
 * @ProjectName chatroom_websocket
 * @Description: TODO
 * @date 2019/8/19 22:04
 */
@WebServlet("/dologin")
public class LoginController extends HttpServlet {
    private AccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+"  "+password);
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        if (CommUtils.strIsNull(username) || CommUtils.strIsNull(password)){
            //登陆失败,依旧停留在登陆页面
            out.println("<script>\n" +
                    "    alert(\"用户名或者密码为空，请重新输入！\");\n" +
                    "    window.location.href = \"/registration.html\";\n" +
                    "</script>");

        }else if (accountService.userLogin(username,password)){
            //登陆成功，跳转聊天页面
            out.println("<script>\n" +
                    "    alert(\"登陆成功！欢迎你\");\n" +
                    "    </script>");
            /*登陆成功跳转页面到聊天页面并且需要把用户名字传到聊天页面，
            * 这样的话在座的各位都知道是谁上线了；
            * 此时后台需要加载chat页面，这个页面是前端的一些东西，我们不用管
            * 只需要如何使用就行。
            * */
            //首先加载一下chat.ftl
            Template template = getTemplate(req,"/chat.ftl");
            Map<String,String> map = new HashMap<>();
            map.put("username",username);
            try {
                //通过template对象把保存进去的username这个项传到聊天页面上去，
                //这样我们就可以直到是谁登陆进入聊天室了
                template.process(map,out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }

        }else {
            //登陆失败。停留在登陆页面
            out.println("<script>\n" +
                    "    alert(\"登陆失败，密码或者用户名错误\");\n" +
                    "    window.location.href = \"/index.html\";\n" +
                    "</script>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private Template getTemplate(HttpServletRequest req,String fileName){
        Configuration cfg =
                (Configuration) req.getServletContext().getAttribute(FreeMarkerListener.TEMPLATE_KEY);
        try {
            return cfg.getTemplate(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
