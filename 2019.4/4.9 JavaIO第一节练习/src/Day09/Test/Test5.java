package Day09.Test;

import java.io.File;
import java.io.IOException;

public class Test5 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:"+File.separator+"Users"+File.separator+
                "dangwuxie"+File.separator+"Desktop"+File.separator+
                "DXC"+File.separator+"JavaIO"+File.separator+"49.txt");
        if (!file.getParentFile().exists()){
            file.mkdirs();
        }
        if (file.exists()){
            file.delete();
        }else {
            file.createNewFile();
        }
    }
}
