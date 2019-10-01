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
@WebServlet("/ServletContext_Test2")
public class ServletContext_Test2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示ServletContext对象的功能
        //首先获取Context对象
        ServletContext context = this.getServletContext();
        //定义文件名称
        String filename = "a.jpg";

        //获取MIME类型
        String mimetype = context.getMimeType(filename);
        System.out.println(mimetype);//image/jpeg



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
