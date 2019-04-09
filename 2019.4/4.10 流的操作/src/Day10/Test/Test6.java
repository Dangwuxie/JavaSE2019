package Day10.Test;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class Test6 {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users" +
                "\\dangwuxie\\Desktop" +
                "\\DXC\\Java49jj\\410.txt");
        Reader reader = new FileReader(file);
        char[] temp = new char[1024];
        reader.read(temp);
        System.out.println("读取的字符为\n"+new String(temp,0,3));
    }
}
