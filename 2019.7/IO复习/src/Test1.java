import java.io.File;
import java.io.IOException;

/**
 * @author Dangxuchao
 * @Title: Test1
 * @ProjectName IO复习
 * @Description: 从最基础开始复习，前面学的知识忘完了。。。
 * @date 2019/7/31 23:08
 */
public class Test1 {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\dangwuxie\\Desktop\\730.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
