package Day03.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

//观察乱码
public class Test3 {
    public static void main(String[] args) throws Exception {
        //C:\Users\dangwuxie\Desktop>
        File file = new File("C:\\Users\\dangwuxie\\Desktop\\A\\B\\C\\JavaIO666.java");
        OutputStream outputStream = new FileOutputStream(file);
        //getBytes可以指定字符编码，把对应得字符格式变为指定得编码格式；
        outputStream.write("撒啊啊啊啊啊阿大撒啊飒飒擦擦".getBytes("ISO-8859-1"));
        outputStream.close();
    }
}
