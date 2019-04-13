package Day11.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test1 {

    public static void main(String[] args) {
        BufferedReader buf =
                new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入信息：");
        try {
            String str = buf.readLine();
            System.out.println("输入信息为："+str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
