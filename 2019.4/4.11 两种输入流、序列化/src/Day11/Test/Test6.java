package Day11.Test;

//Scanner类可以接收任意输入流

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(
                "C:\\Users\\dangwuxie\\Desktop\\DXC\\JavaIO\\a.txt");
        Scanner scan = new Scanner(new FileInputStream(file));
        scan.useDelimiter("\n");
        System.out.println(scan.next());
        scan.close();
    }
}
