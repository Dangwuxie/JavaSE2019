package Day02.Test;
//字符输出流

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test4 {
    public static void main(String[] args) throws IOException {
        //1.取得File对象
        File file = new File("C:\\Users\\dangwuxie\\" +
                "Desktop\\A\\B\\C\\JavaIO666.java");
        //2.取得字符输出流
        Writer writer = new FileWriter(file);
        writer.write("黑黑吼吼吼吼还");
        //writer.close();
        writer.flush();
    }
}
