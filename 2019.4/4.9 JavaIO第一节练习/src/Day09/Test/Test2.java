package Day09.Test;

import java.io.File;


public class Test2 {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\dangwuxie\\Desktop\\49.txt");
        System.out.println(file.exists());
        System.out.println(file.delete());
        System.out.println(file.exists());
    }
}
