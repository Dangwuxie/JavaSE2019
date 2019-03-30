package Day02.Test;
//字节输出流

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Test3 {
    public static void main(String[] args) throws Exception {
        //1.取得File对象
        File file = new File("C:\\Users\\dangwuxie\\" +
                "Desktop\\A\\B\\C\\JavaIO666.java");
        //2.取得输出流
        OutputStream outputStream = new FileOutputStream(file);
        //3.数据输出
        outputStream.write("按时发放撒".getBytes());
        //4.关闭输出流
        outputStream.close();
    }
}
