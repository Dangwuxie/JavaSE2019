package www.bit.day9.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day9_cookie&session
 * @Description: TODO
 * @date 2019/8/10 16:21
 */

/*
*  在服务器的Servlet判断是否有一个名为lasttime的cookie
        1、有：不是第一次访问；欢迎回来，您上次的访问时间为(时间)，然后协会cookie
        2、没有：是第一次访问：
            第一步，响应数据，您好，欢迎您首次访问；
            第二步，写回cookie：lasttime=16点15分
            */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先设置响应的消息体的数据格式以及编号
        response.setContentType("text/html;charset=utf-8");
        boolean flag = false;//没有cookie为lastTime
        //1、获取所有的cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length>0){
            for (Cookie cookie:cookies){

                //获取所有的cookie名称
                String name = cookie.getName();
                //判断名称是否是lastTime
                if ("lastTime".equals(name)){
                //有，不是第一次访问
                    flag = true;
                    //设置cookie的value,获取当前的时间的字符串，重新设置cookie的值
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    cookie.setValue(str_date);

                    //设置cookie存活时间
                    cookie.setMaxAge(200);
                    response.addCookie(cookie);

                    //响应数据，“欢迎回来”，获取cookie的数据，value(时间)
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");
                    //中文数据在响应前需要设置响应体的编码数据格式
                    response.getWriter().write("<h2>欢迎回来，您上次的访问时间为"+value+"</h2>");

                    break;
                }
            }
        }
        if (cookies == null ||cookies.length==0||flag==false){
            //第一次
            //设置cookie的value,获取当前的时间的字符串，重新设置cookie的值
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            str_date = URLEncoder.encode(str_date,"utf-8");
            Cookie cookie = new Cookie("lastTime",str_date);
            //设置cookie存活时间
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎您首次登陆！！！</h1>");


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
