package Day03.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

//使用内存流实现大小写的转换
public class Test4 {
    public static void main(String[] args) throws IOException {
        //首先取得终端对象；
        String str = "hello world";
        ByteArrayInputStream byteArrayInputStream =
                new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream =
                new ByteArrayOutputStream();
        //数据的读取与写入
        int len = 0;
        while ((len = byteArrayInputStream.read()) != -1){
            byteArrayOutputStream.write(Character.toUpperCase(len));
        }
        System.out.println(byteArrayOutputStream);
        byteArrayInputStream.close();
        byteArrayOutputStream.close();

    }
}
