import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Dangxuchao
 * @Title: Test9
 * @ProjectName IO复习
 * @Description: TODO
 * @date 2019/8/7 0:14
 */
public class Test9 {
    public static void main(String[] args) throws IOException {
        OutputStream out = System.out;
        try {
            out.write("我是党旭超".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
