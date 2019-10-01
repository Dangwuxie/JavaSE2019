package www.bit.day8.downloadServlet;

import www.bit.day8.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day8_Response
 * @Description: TODO
 * @date 2019/8/10 11:48
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数、文件名称
        String filename = request.getParameter("filename");
        //2、使用字节输入流加载文件进内存
        //2.1、首先是找到文件服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/"+filename);
        //2.2、然后用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //3、设置response的响应头
        //3.1、设置响应头 content-type
        //首先我们应该先获取文件的mime类型
        String mimeType = context.getMimeType(filename);
        response.setHeader("content-type",mimeType);

        //此处需要解决中文文件名显示不正常的问题
        //1.获取user-agent请求头、
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);

        //3.2、设置下载打开方式的头:content-disposition
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        //4、将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;

        while((len = fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }

        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
