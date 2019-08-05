import java.io.*;

/**
 * @author Dangxuchao
 * @Title: Test5
 * @ProjectName IO复习
 * @Description: 字符输出流，输出到文件中去
 * 字符输入流Reader  读取到程序中来
 * @date 2019/8/5 22:31
 */
public class Test5 {
    public static void main(String[] args) throws IOException {
        /*Writer writer = new FileWriter(
                new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\730.txt"));

        String msg = "今天使星期一";
        writer.write(msg);
        writer.close();*/

        Reader reader = new FileReader(
                new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\730.txt"));

        char[] data = new char[4];

        System.out.println(reader.read(data));
        System.out.println(new String(data));
    }
}
