package Day30.Test;


import java.io.File;
import java.io.IOException;

public class Test1 {

    public static void main(String[] args) throws IOException {
	// write your code here
        //1.取得File对象
        File file = new File(
                "C:"
                        +File.separator +"Users"
                        +File.separator+"dangwuxie"
                        +File.separator+"Desktop"
                        +File.separator+"TestIO.java");
        //file.createNewFile();
        if (file.exists()){
            file.delete();
        }else{
            file.createNewFile();
        }
    }
}
