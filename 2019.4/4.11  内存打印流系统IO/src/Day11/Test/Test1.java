package Day11.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

//乱码产生分析
public class Test1 {

    public static void main(String[] args) throws Exception {
	// write your code here
        OutputStream out = new FileOutputStream(
                new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\Java410\\410.txt")
        );
        out.write("明天过后".getBytes("UTF-8"));
        out.close();
    }
}
