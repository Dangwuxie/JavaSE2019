package Day10.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Test1 {

    public static void main(String[] args) throws Exception {
	// write your code here
        File file = new File("C:\\Users\\dangwuxie\\Desktop" +
                "\\DXC\\Java49\\49.txt");
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        OutputStream output = new FileOutputStream(file);
        output.write("java +\n".getBytes());
        output.write("hello+\n".getBytes());
        output.write("world\n".getBytes());
        output.write("\n123456789".getBytes(),0,4);
        output.close();
    }
}
