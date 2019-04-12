package Day11.Test;

import java.io.*;

//自定义打印流
class PrintUtil{
    private OutputStream out;

    public PrintUtil(OutputStream out){
        this.out = out;
    }

    public void writeString(String str){
        try {
            out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInt(int value){
        writeString(String.valueOf(value));
    }

    public void writeLong(long value){
        writeString(String.valueOf(value));
    }

    public void doubleString(double value){
        writeString(String.valueOf(value));
    }


}
public class Test5 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintUtil printUtil = new PrintUtil(new FileOutputStream(
                new File("C:\\Users\\dangwuxie\\" +
                        "Desktop\\DXC\\JavaIO\\a.txt")));
        printUtil.writeString("啊啊啊啊啊");
        printUtil.writeInt(666666);
        printUtil.writeLong(8888888);
    }
}
