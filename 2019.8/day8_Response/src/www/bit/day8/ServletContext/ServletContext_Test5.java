package www.bit.day8.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day8_Response
 * @Description: TODO
 * @date 2019/8/10 0:09
 */
@WebServlet("/ServletContext_Test5")
public class ServletContext_Test5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示ServletContext对象的功能
        //首先获取Context对象
        ServletContext context = this.getServletContext();
        //获取文件的真实路径
        String b = context.getRealPath("/b.txt");
        System.out.println(b);

        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        /*
        * D:\Github\JavaSE2019\day8_Response\out\artifacts\day8_Response_war_exploded\b.txt
        D:\Github\JavaSE2019\day8_Response\out\artifacts\day8_Response_war_exploded\WEB-INF\c.txt
        */
        String a = context.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(a);
        //D:\Github\JavaSE2019\day8_Response\out\artifacts\day8_Response_war_exploded\WEB-INF\classes\c.txt

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
