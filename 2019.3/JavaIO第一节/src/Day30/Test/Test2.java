package Day30.Test;


import java.io.File;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException {
        //1、取得File对象
        File file = new File(
                "C:"
                        +File.separator +"Users"
                        +File.separator+"dangwuxie"
                        +File.separator+"Desktop"
                        +File.separator+"A"
        +File.separator+"B"+File.separator+"C"
        +File.separator+"JavaIO666.java");
        //file.createNewFile();
        //2、判断父路径是否存在，不存在就创建多级路径
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if (file.exists()){
            System.out.println("文件存在");
        }else{
            file.createNewFile();
        }
       /* System.out.println(file.getParentFile());
        System.out.println(file.getParent());*/
    }
}
