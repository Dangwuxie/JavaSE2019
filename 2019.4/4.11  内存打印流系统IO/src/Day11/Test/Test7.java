package Day11.Test;

import java.io.IOException;
import java.io.InputStream;

//系统输入
public class Test7 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        byte[] data = new byte[1024];
        System.out.println("请输入信息");
        int temp = in.read(data);
        System.out.println("输出内容为："+new String(data,0,temp));
    }
}
