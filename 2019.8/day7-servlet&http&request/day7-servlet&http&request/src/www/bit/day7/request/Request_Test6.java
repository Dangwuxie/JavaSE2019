package www.bit.day7.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day7-servlet&http&request
 * @Description: TODO
 * @date 2019/8/8 0:12
 */
@WebServlet("/Request_Test6")
public class Request_Test6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post获取请求参数
        //根据参数名获取参数值
        /*String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Post:"+username+"  "+password);*/
        //根据参数名称获取参数值的数组
        //String[] data = request.getParameterValues("hobby");
        //System.out.println(data[0]+"  "+data[1]);
        request.setCharacterEncoding("utf-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get获取请求参数
        //根据参数名获取参数值
        //this.doPost(request,response);

        //获取所有请求参数的参数名称
        /*Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("------------------");
        }*/
        //获取所有参数名以及参数值的MAP集合
        Map<String, String[]> map = request.getParameterMap();
        //获取键
        Set<String> stringSet = map.keySet();
        for (String name : stringSet) {
            System.out.println(name);
            String[] values = map.get(name);
            for (String value:values){
                System.out.println(value);
            }
            System.out.println("-----------------");
        }

    }
}

