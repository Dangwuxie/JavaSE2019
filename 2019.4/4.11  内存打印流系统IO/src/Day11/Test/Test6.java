package Day11.Test;

import java.io.*;

//java提供的格式化输出；
public class Test6 {
    public static void main(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(new File(
                            "C:\\Users\\dangwuxie\\" +
                                    "Desktop\\DXC\\JavaIO\\a.txt")));
            printWriter.printf("姓名:%s,年龄:%d,工资:%1.2f","张三",99,21.2311232321232);
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
