package Day10.Test;
//字节流与字符流之间的对比

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test7 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\dangwuxie\\Desktop" +
                "\\DXC\\Java410\\410.txt");
        //如果父路径不存在，那么创建父路径
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        String msg = "今天心情不好";
        Writer writer = new FileWriter(file);
        writer.write(msg);
        writer.flush();
    }
}
