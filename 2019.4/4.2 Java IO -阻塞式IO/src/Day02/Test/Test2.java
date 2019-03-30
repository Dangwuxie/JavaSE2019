package Day02.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Test2 {
    public static void main(String[] args) throws Exception {
        //1.取得终端对象
        File file = new File("C:\\Users\\dangwuxie\\" +
                "Desktop\\A\\B\\C\\JavaIO666.java");
        //2.取得响应输入流
        InputStream in = new FileInputStream(file);
        //3.进行数据的读取
        byte[] data = new byte[1024];
        int len = in.read(data,4,3);
        System.out.println(new String(data));
        //4.关闭流
        in.close();
    }
}
