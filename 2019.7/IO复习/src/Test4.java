import java.io.*;

/**
 * @author Dangxuchao
 * @Title: Test4
 * @ProjectName IO复习
 * @Description: File类文件不支持文件内容处理，必须使用流的操作模式来完成；
 * @date 2019/8/5 18:02
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        //OutputStream ops = new FileOutputStream();

        InputStream in = new FileInputStream(
                new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\730.txt"));
        byte[] data = new byte[1];

        /*for (int i = 0;i < 4;i++){
            System.out.println(in.read(data));
        }*/
        //int len = in.read(data,1,5);

        //System.out.println(new String(data));
        System.out.println(in.available());
        in.close();
    }
}
