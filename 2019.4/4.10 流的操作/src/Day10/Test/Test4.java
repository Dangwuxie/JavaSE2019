package Day10.Test;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test4 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users" +
                "\\dangwuxie\\Desktop" +
                "\\DXC\\Java49\\410.txt");
        InputStream in = new FileInputStream(file);
                byte[] temp = new byte[3];
                int len;
        System.out.println("读取的内容是"+new java.lang.String(temp));
    }
}
