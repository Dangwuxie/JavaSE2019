package www.bit.day8.Response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Dangxuchao
 * @Title: ${NAME}
 * @ProjectName day8_Response
 * @Description: TODO
 * @date 2019/8/9 12:07
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、创建一个对象，这个对象可以在内存中画图，将来就代表验证码的图片对象；
        int width = 150;
        int height = 75;
        int pound = 35;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);

        //2、美化图片
        //2.1、填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.pink);//设置画笔颜色
        g.fillRect(0,0,width,height);
        //2.2、画边框，画一个矩形
        g.setColor(Color.MAGENTA);
        //调整字体的大小，pound参数调整
        g.setFont(new Font("Monaco",Font.BOLD,pound));
        g.drawRect(0,0,width-1,height-1);
        //2.3、写验证码
        //定义一个String[]类型的字符数组
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //创建一个随机的下标
        Random ran = new Random();
        for (int i = 1; i <= 4 ; i++) {
            int index = ran.nextInt(str.length());
            //获取随机字符
            char ch = str.charAt(index);

            g.drawString(ch+"",width/5*i,height/2);
        }
        //设置颜色
        g.setColor(Color.GREEN);
        //画干扰线
        for (int i = 0; i <15 ; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
