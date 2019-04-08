package Day09.Test;

import java.io.File;

public class Test4 {
    public static void main(String[] args) {
        File file = new File("C:"+File.separator+"Users"+File.separator+
                "dangwuxie"+File.separator+"Desktop"+File.separator+"49.txt");
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
    }
}
