package PrintUtils;

import java.io.*;

/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName IO复习
 * @Description: TODO
 * @date 2019/8/6 23:45
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\dangwuxie\\Desktop\\DXC\\A.txt");
        OutputStream out = new FileOutputStream(file);
        PrintUtils printUtils = new PrintUtils(out);

        printUtils.print("党旭超");
        printUtils.printDouble(22.44);
        printUtils.printInt(22);
        printUtils.printString("sadadas");
        printUtils.close();
    }
}
