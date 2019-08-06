import java.io.IOException;
import java.io.InputStream;

/**
 * @author Dangxuchao
 * @Title: Test10
 * @ProjectName IO复习
 * @Description: TODO
 * @date 2019/8/7 0:25
 */
public class Test10 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        byte[] data = new byte[4];
        int temp = in.read(data);
        System.out.println(new String(data,0,temp));
    }
}
