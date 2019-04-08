package Day09.Test;

import java.io.File;

//递归出目录下的所有文件；
public class Test8 {
    public static void main(String[] args) {
        File file = new File("C:\\Java IDEA\\" +
                "IntelliJ IDEA 2018.1.6\\bin");
        listAllFiles(file);
    }
    public static void listAllFiles(File file){
        File[] temp = file.listFiles();
        if (temp != null){
            for(File o : temp){
                listAllFiles(o);
            }
        }else{
            System.out.println(file);
        }
    }
}
