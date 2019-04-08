package Day09.Test;

import java.io.File;
public class Test7 {
    public static void main(String[] args) {
        File file = new File("C:"+File.separator+
                "Users"+File.separator+
                "dangwuxie"+File.separator+"Desktop");
        if (file.exists() && file.isDirectory()){
            File[] temp = file.listFiles();
            for (File o : temp){
                System.out.println(o);
            }
        }
    }
}
