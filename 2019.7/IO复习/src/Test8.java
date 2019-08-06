import java.io.*;

/**
 * @author Dangxuchao
 * @Title: Test8
 * @ProjectName IO复习
 * @Description: 打印流，OutputStream的加强版，解决了它的两个缺陷
 * @date 2019/8/6 22:46
 */
public class Test8 {
    public static void main(String[] args) throws FileNotFoundException {
        //使用系统提供好的打印流
        PrintWriter printWriter = new PrintWriter(
                new FileOutputStream(new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\B.txt")));

        printWriter.print(1);
        printWriter.print("你好");
        printWriter.print(11.22);
        printWriter.close();
    }
}
