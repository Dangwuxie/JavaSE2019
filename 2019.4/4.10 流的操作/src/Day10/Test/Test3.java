package Day10.Test;

import java.io.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users" +
                "\\dangwuxie\\Desktop" +
                "\\DXC\\Java49\\410.txt");
        if (file.isFile() && file.exists()){
            try (InputStream in = new FileInputStream(file)){
                /*int b = in.read();
                System.out.println(b);*/
                byte[] temp  = new byte[3];
                int len = 0;
                while ((len = in.read(temp)) != -1){

                    System.out.println(new String(temp,0,len));
                }
                //System.out.println();
                //int length = in.read(temp,2,3);
                //System.out.println("读取的长度是"+length);
                //System.out.println("读取的内容是"+new String(temp));
            }
        }
    }
}
