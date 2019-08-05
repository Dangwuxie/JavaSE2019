import java.io.*;

/**
 * @author Dangxuchao
 * @Title: Test6
 * @ProjectName IO复习
 * @Description: TODO
 * @date 2019/8/5 23:15
 */
public class Test6 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\730.txt");
       /* OutputStream output = new FileOutputStream(file,true);
        Writer out = new OutputStreamWriter(output);
        out.write("你好呀");
        out.close();*/

       InputStream input = new FileInputStream(file);
       Reader in = new InputStreamReader(input);
       char[] data = new char[5];
        System.out.println(in.read(data));
       System.out.println(new String(data));

        in.close();
    }
}
