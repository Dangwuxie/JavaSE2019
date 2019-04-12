package Day11.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

//优化，可以引入内存流，解决一次性读不完的额问题；
public class Test8 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[10];
        System.out.println("请输入信息");
        int temp = 0;
        while((temp = in.read(data,2,2)) != -1){
            System.out.println(temp);
            bos.write(data,0,temp);
            if (temp <= data.length){
                break;
            }
        }
        in.close();
        bos.close();
        System.out.println("输入内容为："+new String(bos.toByteArray()));
    }
}
