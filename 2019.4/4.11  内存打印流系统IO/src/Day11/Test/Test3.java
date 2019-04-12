package Day11.Test;

import java.io.*;

//内存流实现文件合并
public class Test3 {
    public static void main(String[] args) throws Exception {

        try ( InputStream a = new FileInputStream(
                "C:\\Users\\dangwuxie\\Desktop\\DXC\\JavaIO\\1.txt");
              InputStream b = new FileInputStream(
                      "C:\\Users\\dangwuxie\\Desktop\\DXC\\JavaIO\\2.txt");
              OutputStream c = new FileOutputStream(
                      "C:\\Users\\dangwuxie\\Desktop\\DXC\\JavaIO\\a.txt");
              ByteArrayOutputStream bout = new ByteArrayOutputStream()
        ) {
            byte[] buff = new byte[4];
            int len = -1;
            while ((len = a.read(buff)) != -1){
                bout.write(buff,0,len);
            }
            while ((len = b.read(buff)) != -1){
                bout.write(buff,0,len);
            }

            byte[] data = bout.toByteArray();
            c.write(data);
            c.flush();
        }
        //a->bout
        //b->bout
        //bout->fout

    }
}
