package Day11.Test;

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        String msg = "AAABBBCCCDDDEEE";
        OutputStream output = new ByteArrayOutputStream();
        InputStream input = new ByteArrayInputStream(msg.getBytes());
        int len = 0;
        while ((len = input.read()) != -1){
            output.write(Character.toLowerCase(len));
        }
        System.out.println(output);
        input.close();
        output.close();
    }
}
