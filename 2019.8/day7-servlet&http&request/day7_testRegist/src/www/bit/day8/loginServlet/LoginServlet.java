package www.bit.day8.loginServlet;

import org.apache.commons.beanutils.BeanUtils;
import www.bit.day8.registTest.User;
import www.bit.day8.userdao.Userdao;

import javax.jws.WebService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Dangxuchao
 * @Title: LoginServlet
 * @ProjectName day7-servlet&http&request
 * @Description: TODO
 * @date 2019/8/8 18:36
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、设置编码
        req.setCharacterEncoding("utf-8");
        //2、获取请求参数
       /* String username = req.getParameter("username");
        String passsword = req.getParameter("password");
        //3、封装user对象
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(passsword);*/

       //获取所有请求参数
        Map<String,String[]> map = req.getParameterMap();
        //创建一个User对象
        User loginuser = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4、调用UserDao的login方法
        Userdao userdao = new Userdao();
        User user = userdao.login(loginuser);
        //5、判断user
        if (user == null){
            //登陆失败
            req.getRequestDispatcher("/FailServlet").forward(req,resp);
        }else {
            resp.setContentType("text/html;charset=utf-8");
            //成功
            //存储数据
            req.setAttribute("user",user);
            req.setAttribute("loginuser",loginuser);
            //resp.getWriter().write(loginuser.toString());
            //装法
            req.getRequestDispatcher("/SuccessServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
