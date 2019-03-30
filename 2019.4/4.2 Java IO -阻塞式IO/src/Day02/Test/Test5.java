package Day02.Test;
//字符输入流

import java.io.File;
import java.io.FileReader;
import java.io.Reader;


public class Test5 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\dangwuxie\\"
                + "Desktop\\A\\B\\C\\JavaIO666.java");
        Reader reader = new FileReader(file);
        char[] data = new char[1024];
        int len = reader.read(data);
        System.out.println("文件内容为："+
        new String(data,0,len));
        reader.close();
    }
}
