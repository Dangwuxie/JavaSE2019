package Day11.Test;

//使用系统提供的打印流printUtil类；
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test4 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new File(
                "C:\\Users\\dangwuxie\\Desktop\\DXC\\JavaIO\\a.txt")) ;
        printWriter.write(65);
        printWriter.flush();
    }
}
