package Day09.Test;

import java.io.File;

public class Test3 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:"+File.separator+"Users"+File.separator+
                "dangwuxie"+File.separator+"Desktop"+File.separator+"49.txt");
        file.createNewFile();

    }
}
