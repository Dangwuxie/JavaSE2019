package Day10.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Test2 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users" +
                "\\dangwuxie\\Desktop" +
                "\\DXC\\Java49\\410.txt");

        try(OutputStream out = new FileOutputStream(file)) {
            out.write("hello !+\n".getBytes());
            out.write("world!\n+".getBytes());
            out.write("666666666666\n+".getBytes());
            out.write(49);
            out.write(65);
            out.write(97);
            out.write(122);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
