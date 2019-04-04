package Day30.Test;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Test3 {
    public static void main(String[] args)throws Exception {
        //1.取得终端对象
        File file = new File(
                "C:"
                        +File.separator +"Users"
                        +File.separator+"dangwuxie"
                        +File.separator+"Desktop"
                        +File.separator+"A"
                        +File.separator+"B"+File.separator+"C"
                        +File.separator+"JavaIO666.java");
        //2.根据终端取得指定文件的输出流
        //向上转型为OutputStream
        OutputStream out = new FileOutputStream(file,true);
        //第三步：进行数据的输出
        String str = "hello world";
        out.write(str.getBytes());
        //4.关闭流
        out.close();

    }
}
