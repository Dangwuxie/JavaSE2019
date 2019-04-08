package Day09.Test;

import java.io.File;
import java.util.Date;

public class Test6 {
    public static void main(String[] args) {
        File file = new File("C:"+File.separator+"Users"+File.separator+
                "dangwuxie"+File.separator+"Desktop"+File.separator+
                "DXC"+File.separator+"JavaIO"+File.separator+"49.txt");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        if (file.exists() && file.isFile()){
            System.out.println("文件大小："+file.length());
            System.out.println("最后一次修改日期："+new Date(file.lastModified()));
        }
    }
}
