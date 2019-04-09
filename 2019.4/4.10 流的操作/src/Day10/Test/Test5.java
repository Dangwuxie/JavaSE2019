package Day10.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Test5{
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users" +
                "\\dangwuxie\\Desktop" +
                "\\DXC\\Java49jj\\410.txt");
        System.out.println(file.getParentFile().exists());
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        Writer writer = new FileWriter(file,true);
        writer.write("穿越火线");
        writer.close();
    }
}