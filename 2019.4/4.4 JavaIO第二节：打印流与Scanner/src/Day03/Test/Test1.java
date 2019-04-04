package Day03.Test;


import java.io.*;

public class Test1 {

    public static void main(String[] args) throws Exception {
	// write your code here
        File file = new File
                ("C:\\Users\\dangwuxie\\Desktop" +
                        "\\A\\B\\C\\JavaIO666.java");
        Writer out = new OutputStreamWriter(new FileOutputStream(file));
        out.write("明天啊啊啊啊啊啊");
        out.close();
    }
}
