package Day10.Test;
//转换流


import java.io.*;

public class Test8 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\dangwuxie\\Desktop" +
                "\\DXC\\Java410\\410.txt");
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        OutputStream outputStream = new FileOutputStream(file);
        //字节流转换为字符流
        Writer writer = new OutputStreamWriter(outputStream);
        String msg = "今天很开心";
        writer.write(msg);
        writer.flush();
    }
}
