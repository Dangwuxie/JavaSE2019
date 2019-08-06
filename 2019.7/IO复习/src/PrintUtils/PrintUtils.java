package PrintUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Dangxuchao
 * @Title: PrintUtils
 * @ProjectName IO复习
 * @Description: 打印流自己实现
 * @date 2019/8/6 23:39
 */
public class PrintUtils {
    private OutputStream out;

    public PrintUtils(OutputStream out) {
        this.out = out;
    }

    public void print(String str){
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printInt(int data){
        this.print(String.valueOf(data));
    }

    public void printString(String str){
        this.print(str);
    }

    public void printDouble(double data){
        this.print(String.valueOf(data));
    }

    public void close() throws IOException {
        out.close();
    }
}
